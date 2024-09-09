package infrastructure.scheduler;

import domain.annotation.Principal;
import domain.election.Election;
import infrastructure.repository.RedisElectionRepository;
import infrastructure.repository.SqlElectionRepository;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Sync {

    private final SqlElectionRepository sqlElectionRepository;
    private final RedisElectionRepository redisElectionRepository;

    public Sync(@Principal SqlElectionRepository sqlElectionRepository, RedisElectionRepository redisElectionRepository) {
        this.sqlElectionRepository = sqlElectionRepository;
        this.redisElectionRepository = redisElectionRepository;
    }

    @Scheduled(cron = "*/10 * * * * ?")
    void sync() {
        sqlElectionRepository.findAll().forEach(election -> {
            Election updated = redisElectionRepository.sync(election);
            sqlElectionRepository.sync(updated);
        });
    }
}
