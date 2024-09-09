package infrastructure.lifecycle;

import domain.Election;
import infrastructure.repository.RedisElectionRepository;
import io.quarkus.redis.datasource.ReactiveRedisDataSource;
import io.quarkus.runtime.Startup;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.logging.Logger;

@Startup
@ApplicationScoped
public class Subscribe {

    private static final Logger LOGGER = Logger.getLogger(Subscribe.class.getName());

    public Subscribe(ReactiveRedisDataSource reactiveRedisDataSource, RedisElectionRepository repository) {
        // Non-blocking connection
        Multi<String> sub = reactiveRedisDataSource.pubsub(String.class).subscribe("elections");
        sub.emitOn(Infrastructure.getDefaultWorkerPool())
                .subscribe()
                .with(id -> {
                    LOGGER.info("Election " + id + " received from subscription");
                    Election election = repository.findById(id);
                    LOGGER.info("Election " + election.id() + " starting");
                });

       /* Blocking connection
        redisDataSource.pubsub(String.class).subscribe("elections", id -> {
            LOGGER.info("Election " + id + " received from subscription");

            Election election = repository.findById(id);
            LOGGER.info("Election " + election.id() + " starting");
        });*/
    }
}
