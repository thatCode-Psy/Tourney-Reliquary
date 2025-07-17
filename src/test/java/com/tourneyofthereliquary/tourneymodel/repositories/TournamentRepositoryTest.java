package com.tourneyofthereliquary.tourneymodel.repositories;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.TestcontainersConfiguration;

import com.redis.testcontainers.RedisContainer;
import com.tourneyofthereliquary.tourneymodel.TestRedisConfiguration;
import com.tourneyofthereliquary.tourneyrestendpoint.RestEndpointApplication;
import com.tourneyofthereliquary.tourneyrestendpoint.configurations.RedisConfiguration;
import com.tourneyofthereliquary.tourneyrestendpoint.models.Match;
import com.tourneyofthereliquary.tourneyrestendpoint.models.Player;
import com.tourneyofthereliquary.tourneyrestendpoint.models.Round;
import com.tourneyofthereliquary.tourneyrestendpoint.models.MagicPlayerRecord;
import com.tourneyofthereliquary.tourneyrestendpoint.models.Tournament;
import com.tourneyofthereliquary.tourneyrestendpoint.repositories.TournamentRepository;

import reactor.test.StepVerifier;
import reactor.core.publisher.Mono;

@SpringBootTest
// @ImportTestcontainers(TestcontainersConfiguration.class)
@Import(TestRedisConfiguration.class)
@ContextConfiguration(classes = {RedisConfiguration.class, TournamentRepository.class})
public class TournamentRepositoryTest {

    @Autowired
    TournamentRepository tournamentRepository;

    private Tournament tournament;

    @BeforeEach
    public void setup() {
        tournament = new Tournament("1", "test", new TreeSet<Player>(), new LinkedList<Round>());
    }

    @Test
    public void saveTest() {
        StepVerifier.create(tournamentRepository.save(tournament))
            .expectNext(tournament)
            .verifyComplete();
    }

    @Test
    public void findTest() {
        StepVerifier.create(tournamentRepository.save(tournament).flatMap(_ -> tournamentRepository.findByKey(tournament.getId())))
                    .expectNext(tournament)
                    .verifyComplete();
    }

    @Test
    public void addPlayerLengthTest() {
        Player player1 = new Player("player1", "testPlayer1", new MagicPlayerRecord(), new HashSet<Player>());

        StepVerifier.create(tournamentRepository.save(tournament)
                                                .flatMap(_ -> tournamentRepository.addPlayerToTournament(tournament.getId(), player1)))
                    .expectNext(1L)
                    .verifyComplete();

    }

    @Test
    public void addPlayerResultTest() {
        Player player1 = new Player("player1", "testPlayer1", new MagicPlayerRecord(), new HashSet<Player>());
        Player player2 = new Player("player2", "testPlayer2", new MagicPlayerRecord(), new HashSet<Player>());
        
        Mono<Tournament> source = tournamentRepository.save(tournament)
                                                .flatMap(_ -> tournamentRepository.addPlayerToTournament(tournament.getId(), player1))
                                                .flatMap(_ -> tournamentRepository.addPlayerToTournament(tournament.getId(), player2))
                                                .flatMap(_ -> tournamentRepository.findByKey(tournament.getId()));

        StepVerifier.create(source)
                    .assertNext(tourney -> assertTrue(tourney.getPlayers().contains(player1) 
                                            && tourney.getPlayers().contains(player2)))
                    .verifyComplete();
    }
}
