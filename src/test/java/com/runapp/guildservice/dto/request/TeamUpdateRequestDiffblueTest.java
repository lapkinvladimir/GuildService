package com.runapp.guildservice.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TeamUpdateRequest.class})
@ExtendWith(SpringExtension.class)
class TeamUpdateRequestDiffblueTest {
    @Autowired
    private TeamUpdateRequest teamUpdateRequest;

    /**
     * Method under test: {@link TeamUpdateRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(teamUpdateRequest.canEqual("Other"));
        assertTrue(teamUpdateRequest.canEqual(teamUpdateRequest));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamUpdateRequest#TeamUpdateRequest()}
     *   <li>{@link TeamUpdateRequest#setAdminId(int)}
     *   <li>{@link TeamUpdateRequest#setDescriptionTeam(String)}
     *   <li>{@link TeamUpdateRequest#setMaximumPlayers(int)}
     *   <li>{@link TeamUpdateRequest#setRanking(Long)}
     *   <li>{@link TeamUpdateRequest#setStoryId(int)}
     *   <li>{@link TeamUpdateRequest#setTeamName(String)}
     *   <li>{@link TeamUpdateRequest#toString()}
     *   <li>{@link TeamUpdateRequest#getAdminId()}
     *   <li>{@link TeamUpdateRequest#getDescriptionTeam()}
     *   <li>{@link TeamUpdateRequest#getMaximumPlayers()}
     *   <li>{@link TeamUpdateRequest#getRanking()}
     *   <li>{@link TeamUpdateRequest#getStoryId()}
     *   <li>{@link TeamUpdateRequest#getTeamName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        TeamUpdateRequest actualTeamUpdateRequest = new TeamUpdateRequest();
        actualTeamUpdateRequest.setAdminId(1);
        actualTeamUpdateRequest.setDescriptionTeam("Description Team");
        actualTeamUpdateRequest.setMaximumPlayers(3);
        actualTeamUpdateRequest.setRanking(1L);
        actualTeamUpdateRequest.setStoryId(1);
        actualTeamUpdateRequest.setTeamName("Team Name");
        String actualToStringResult = actualTeamUpdateRequest.toString();
        int actualAdminId = actualTeamUpdateRequest.getAdminId();
        String actualDescriptionTeam = actualTeamUpdateRequest.getDescriptionTeam();
        int actualMaximumPlayers = actualTeamUpdateRequest.getMaximumPlayers();
        Long actualRanking = actualTeamUpdateRequest.getRanking();
        int actualStoryId = actualTeamUpdateRequest.getStoryId();
        assertEquals("Description Team", actualDescriptionTeam);
        assertEquals("Team Name", actualTeamUpdateRequest.getTeamName());
        assertEquals("TeamUpdateRequest(teamName=Team Name, descriptionTeam=Description Team, storyId=1, maximumPlayers=3,"
                + " adminId=1, ranking=1)", actualToStringResult);
        assertEquals(1, actualAdminId);
        assertEquals(1, actualStoryId);
        assertEquals(1L, actualRanking.longValue());
        assertEquals(3, actualMaximumPlayers);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link TeamUpdateRequest#TeamUpdateRequest(String, String, int, int, int, Long)}
     *   <li>{@link TeamUpdateRequest#setAdminId(int)}
     *   <li>{@link TeamUpdateRequest#setDescriptionTeam(String)}
     *   <li>{@link TeamUpdateRequest#setMaximumPlayers(int)}
     *   <li>{@link TeamUpdateRequest#setRanking(Long)}
     *   <li>{@link TeamUpdateRequest#setStoryId(int)}
     *   <li>{@link TeamUpdateRequest#setTeamName(String)}
     *   <li>{@link TeamUpdateRequest#toString()}
     *   <li>{@link TeamUpdateRequest#getAdminId()}
     *   <li>{@link TeamUpdateRequest#getDescriptionTeam()}
     *   <li>{@link TeamUpdateRequest#getMaximumPlayers()}
     *   <li>{@link TeamUpdateRequest#getRanking()}
     *   <li>{@link TeamUpdateRequest#getStoryId()}
     *   <li>{@link TeamUpdateRequest#getTeamName()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        TeamUpdateRequest actualTeamUpdateRequest = new TeamUpdateRequest("Team Name", "Description Team", 1, 3, 1, 1L);
        actualTeamUpdateRequest.setAdminId(1);
        actualTeamUpdateRequest.setDescriptionTeam("Description Team");
        actualTeamUpdateRequest.setMaximumPlayers(3);
        actualTeamUpdateRequest.setRanking(1L);
        actualTeamUpdateRequest.setStoryId(1);
        actualTeamUpdateRequest.setTeamName("Team Name");
        String actualToStringResult = actualTeamUpdateRequest.toString();
        int actualAdminId = actualTeamUpdateRequest.getAdminId();
        String actualDescriptionTeam = actualTeamUpdateRequest.getDescriptionTeam();
        int actualMaximumPlayers = actualTeamUpdateRequest.getMaximumPlayers();
        Long actualRanking = actualTeamUpdateRequest.getRanking();
        int actualStoryId = actualTeamUpdateRequest.getStoryId();
        assertEquals("Description Team", actualDescriptionTeam);
        assertEquals("Team Name", actualTeamUpdateRequest.getTeamName());
        assertEquals("TeamUpdateRequest(teamName=Team Name, descriptionTeam=Description Team, storyId=1, maximumPlayers=3,"
                + " adminId=1, ranking=1)", actualToStringResult);
        assertEquals(1, actualAdminId);
        assertEquals(1, actualStoryId);
        assertEquals(1L, actualRanking.longValue());
        assertEquals(3, actualMaximumPlayers);
    }

    /**
     * Method under test: {@link TeamUpdateRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new TeamUpdateRequest(), null);
        assertNotEquals(new TeamUpdateRequest(), "Different type to TeamUpdateRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamUpdateRequest#equals(Object)}
     *   <li>{@link TeamUpdateRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        TeamUpdateRequest teamUpdateRequest = new TeamUpdateRequest();
        assertEquals(teamUpdateRequest, teamUpdateRequest);
        int expectedHashCodeResult = teamUpdateRequest.hashCode();
        assertEquals(expectedHashCodeResult, teamUpdateRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamUpdateRequest#equals(Object)}
     *   <li>{@link TeamUpdateRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        TeamUpdateRequest teamUpdateRequest = new TeamUpdateRequest();
        TeamUpdateRequest teamUpdateRequest2 = new TeamUpdateRequest();
        assertEquals(teamUpdateRequest, teamUpdateRequest2);
        int expectedHashCodeResult = teamUpdateRequest.hashCode();
        assertEquals(expectedHashCodeResult, teamUpdateRequest2.hashCode());
    }

    /**
     * Method under test: {@link TeamUpdateRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        TeamUpdateRequest teamUpdateRequest = new TeamUpdateRequest("Team Name", "Description Team", 1, 3, 1, 1L);
        assertNotEquals(teamUpdateRequest, new TeamUpdateRequest());
    }

    /**
     * Method under test: {@link TeamUpdateRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        TeamUpdateRequest teamUpdateRequest = new TeamUpdateRequest();
        teamUpdateRequest.setTeamName("Team Name");
        assertNotEquals(teamUpdateRequest, new TeamUpdateRequest());
    }

    /**
     * Method under test: {@link TeamUpdateRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        TeamUpdateRequest teamUpdateRequest = new TeamUpdateRequest();
        teamUpdateRequest.setDescriptionTeam("Description Team");
        assertNotEquals(teamUpdateRequest, new TeamUpdateRequest());
    }

    /**
     * Method under test: {@link TeamUpdateRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        TeamUpdateRequest teamUpdateRequest = new TeamUpdateRequest();
        teamUpdateRequest.setMaximumPlayers(3);
        assertNotEquals(teamUpdateRequest, new TeamUpdateRequest());
    }

    /**
     * Method under test: {@link TeamUpdateRequest#equals(Object)}
     */
    @Test
    void testEquals8() {
        TeamUpdateRequest teamUpdateRequest = new TeamUpdateRequest();
        teamUpdateRequest.setAdminId(1);
        assertNotEquals(teamUpdateRequest, new TeamUpdateRequest());
    }

    /**
     * Method under test: {@link TeamUpdateRequest#equals(Object)}
     */
    @Test
    void testEquals9() {
        TeamUpdateRequest teamUpdateRequest = new TeamUpdateRequest();
        teamUpdateRequest.setRanking(1L);
        assertNotEquals(teamUpdateRequest, new TeamUpdateRequest());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamUpdateRequest#equals(Object)}
     *   <li>{@link TeamUpdateRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        TeamUpdateRequest teamUpdateRequest = new TeamUpdateRequest("Team Name", "Description Team", 1, 3, 1, 1L);
        TeamUpdateRequest teamUpdateRequest2 = new TeamUpdateRequest("Team Name", "Description Team", 1, 3, 1, 1L);

        assertEquals(teamUpdateRequest, teamUpdateRequest2);
        int expectedHashCodeResult = teamUpdateRequest.hashCode();
        assertEquals(expectedHashCodeResult, teamUpdateRequest2.hashCode());
    }

    /**
     * Method under test: {@link TeamUpdateRequest#equals(Object)}
     */
    @Test
    void testEquals11() {
        TeamUpdateRequest teamUpdateRequest = new TeamUpdateRequest();

        TeamUpdateRequest teamUpdateRequest2 = new TeamUpdateRequest();
        teamUpdateRequest2.setTeamName("Team Name");
        assertNotEquals(teamUpdateRequest, teamUpdateRequest2);
    }

    /**
     * Method under test: {@link TeamUpdateRequest#equals(Object)}
     */
    @Test
    void testEquals12() {
        TeamUpdateRequest teamUpdateRequest = new TeamUpdateRequest();

        TeamUpdateRequest teamUpdateRequest2 = new TeamUpdateRequest();
        teamUpdateRequest2.setDescriptionTeam("Description Team");
        assertNotEquals(teamUpdateRequest, teamUpdateRequest2);
    }

    /**
     * Method under test: {@link TeamUpdateRequest#equals(Object)}
     */
    @Test
    void testEquals13() {
        TeamUpdateRequest teamUpdateRequest = new TeamUpdateRequest();

        TeamUpdateRequest teamUpdateRequest2 = new TeamUpdateRequest();
        teamUpdateRequest2.setRanking(1L);
        assertNotEquals(teamUpdateRequest, teamUpdateRequest2);
    }
}
