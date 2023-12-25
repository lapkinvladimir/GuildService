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

@ContextConfiguration(classes = {TeamRequest.class})
@ExtendWith(SpringExtension.class)
class TeamRequestDiffblueTest {
    @Autowired
    private TeamRequest teamRequest;

    /**
     * Method under test: {@link TeamRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(teamRequest.canEqual("Other"));
        assertTrue(teamRequest.canEqual(teamRequest));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamRequest#TeamRequest()}
     *   <li>{@link TeamRequest#setAdminId(int)}
     *   <li>{@link TeamRequest#setDescriptionTeam(String)}
     *   <li>{@link TeamRequest#setMaximumPlayers(int)}
     *   <li>{@link TeamRequest#setStoryId(int)}
     *   <li>{@link TeamRequest#setTeamName(String)}
     *   <li>{@link TeamRequest#toString()}
     *   <li>{@link TeamRequest#getAdminId()}
     *   <li>{@link TeamRequest#getDescriptionTeam()}
     *   <li>{@link TeamRequest#getMaximumPlayers()}
     *   <li>{@link TeamRequest#getStoryId()}
     *   <li>{@link TeamRequest#getTeamName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        TeamRequest actualTeamRequest = new TeamRequest();
        actualTeamRequest.setAdminId(1);
        actualTeamRequest.setDescriptionTeam("Description Team");
        actualTeamRequest.setMaximumPlayers(3);
        actualTeamRequest.setStoryId(1);
        actualTeamRequest.setTeamName("Team Name");
        String actualToStringResult = actualTeamRequest.toString();
        int actualAdminId = actualTeamRequest.getAdminId();
        String actualDescriptionTeam = actualTeamRequest.getDescriptionTeam();
        int actualMaximumPlayers = actualTeamRequest.getMaximumPlayers();
        int actualStoryId = actualTeamRequest.getStoryId();
        assertEquals("Description Team", actualDescriptionTeam);
        assertEquals("Team Name", actualTeamRequest.getTeamName());
        assertEquals("TeamRequest(teamName=Team Name, descriptionTeam=Description Team, storyId=1, maximumPlayers=3,"
                + " adminId=1)", actualToStringResult);
        assertEquals(1, actualAdminId);
        assertEquals(1, actualStoryId);
        assertEquals(3, actualMaximumPlayers);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamRequest#TeamRequest(String, String, int, int, int)}
     *   <li>{@link TeamRequest#setAdminId(int)}
     *   <li>{@link TeamRequest#setDescriptionTeam(String)}
     *   <li>{@link TeamRequest#setMaximumPlayers(int)}
     *   <li>{@link TeamRequest#setStoryId(int)}
     *   <li>{@link TeamRequest#setTeamName(String)}
     *   <li>{@link TeamRequest#toString()}
     *   <li>{@link TeamRequest#getAdminId()}
     *   <li>{@link TeamRequest#getDescriptionTeam()}
     *   <li>{@link TeamRequest#getMaximumPlayers()}
     *   <li>{@link TeamRequest#getStoryId()}
     *   <li>{@link TeamRequest#getTeamName()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        TeamRequest actualTeamRequest = new TeamRequest("Team Name", "Description Team", 1, 3, 1);
        actualTeamRequest.setAdminId(1);
        actualTeamRequest.setDescriptionTeam("Description Team");
        actualTeamRequest.setMaximumPlayers(3);
        actualTeamRequest.setStoryId(1);
        actualTeamRequest.setTeamName("Team Name");
        String actualToStringResult = actualTeamRequest.toString();
        int actualAdminId = actualTeamRequest.getAdminId();
        String actualDescriptionTeam = actualTeamRequest.getDescriptionTeam();
        int actualMaximumPlayers = actualTeamRequest.getMaximumPlayers();
        int actualStoryId = actualTeamRequest.getStoryId();
        assertEquals("Description Team", actualDescriptionTeam);
        assertEquals("Team Name", actualTeamRequest.getTeamName());
        assertEquals("TeamRequest(teamName=Team Name, descriptionTeam=Description Team, storyId=1, maximumPlayers=3,"
                + " adminId=1)", actualToStringResult);
        assertEquals(1, actualAdminId);
        assertEquals(1, actualStoryId);
        assertEquals(3, actualMaximumPlayers);
    }

    /**
     * Method under test: {@link TeamRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new TeamRequest("Team Name", "Description Team", 1, 3, 1), null);
        assertNotEquals(new TeamRequest("Team Name", "Description Team", 1, 3, 1), "Different type to TeamRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamRequest#equals(Object)}
     *   <li>{@link TeamRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        TeamRequest teamRequest = new TeamRequest("Team Name", "Description Team", 1, 3, 1);
        assertEquals(teamRequest, teamRequest);
        int expectedHashCodeResult = teamRequest.hashCode();
        assertEquals(expectedHashCodeResult, teamRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamRequest#equals(Object)}
     *   <li>{@link TeamRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        TeamRequest teamRequest = new TeamRequest("Team Name", "Description Team", 1, 3, 1);
        TeamRequest teamRequest2 = new TeamRequest("Team Name", "Description Team", 1, 3, 1);

        assertEquals(teamRequest, teamRequest2);
        int expectedHashCodeResult = teamRequest.hashCode();
        assertEquals(expectedHashCodeResult, teamRequest2.hashCode());
    }

    /**
     * Method under test: {@link TeamRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        TeamRequest teamRequest = new TeamRequest("Description Team", "Description Team", 1, 3, 1);
        assertNotEquals(teamRequest, new TeamRequest("Team Name", "Description Team", 1, 3, 1));
    }

    /**
     * Method under test: {@link TeamRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        TeamRequest teamRequest = new TeamRequest(null, "Description Team", 1, 3, 1);
        assertNotEquals(teamRequest, new TeamRequest("Team Name", "Description Team", 1, 3, 1));
    }

    /**
     * Method under test: {@link TeamRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        TeamRequest teamRequest = new TeamRequest("Team Name", "Team Name", 1, 3, 1);
        assertNotEquals(teamRequest, new TeamRequest("Team Name", "Description Team", 1, 3, 1));
    }

    /**
     * Method under test: {@link TeamRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        TeamRequest teamRequest = new TeamRequest("Team Name", null, 1, 3, 1);
        assertNotEquals(teamRequest, new TeamRequest("Team Name", "Description Team", 1, 3, 1));
    }

    /**
     * Method under test: {@link TeamRequest#equals(Object)}
     */
    @Test
    void testEquals8() {
        TeamRequest teamRequest = new TeamRequest("Team Name", "Description Team", 2, 3, 1);
        assertNotEquals(teamRequest, new TeamRequest("Team Name", "Description Team", 1, 3, 1));
    }

    /**
     * Method under test: {@link TeamRequest#equals(Object)}
     */
    @Test
    void testEquals9() {
        TeamRequest teamRequest = new TeamRequest("Team Name", "Description Team", 1, 1, 1);
        assertNotEquals(teamRequest, new TeamRequest("Team Name", "Description Team", 1, 3, 1));
    }

    /**
     * Method under test: {@link TeamRequest#equals(Object)}
     */
    @Test
    void testEquals10() {
        TeamRequest teamRequest = new TeamRequest("Team Name", "Description Team", 1, 3, 2);
        assertNotEquals(teamRequest, new TeamRequest("Team Name", "Description Team", 1, 3, 1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamRequest#equals(Object)}
     *   <li>{@link TeamRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals11() {
        TeamRequest teamRequest = new TeamRequest(null, "Description Team", 1, 3, 1);
        TeamRequest teamRequest2 = new TeamRequest(null, "Description Team", 1, 3, 1);

        assertEquals(teamRequest, teamRequest2);
        int expectedHashCodeResult = teamRequest.hashCode();
        assertEquals(expectedHashCodeResult, teamRequest2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamRequest#equals(Object)}
     *   <li>{@link TeamRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals12() {
        TeamRequest teamRequest = new TeamRequest("Team Name", null, 1, 3, 1);
        TeamRequest teamRequest2 = new TeamRequest("Team Name", null, 1, 3, 1);

        assertEquals(teamRequest, teamRequest2);
        int expectedHashCodeResult = teamRequest.hashCode();
        assertEquals(expectedHashCodeResult, teamRequest2.hashCode());
    }
}
