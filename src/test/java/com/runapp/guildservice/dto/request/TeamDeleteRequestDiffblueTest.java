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

@ContextConfiguration(classes = {TeamDeleteRequest.class})
@ExtendWith(SpringExtension.class)
class TeamDeleteRequestDiffblueTest {
    @Autowired
    private TeamDeleteRequest teamDeleteRequest;

    /**
     * Method under test: {@link TeamDeleteRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(teamDeleteRequest.canEqual("Other"));
        assertTrue(teamDeleteRequest.canEqual(teamDeleteRequest));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamDeleteRequest#TeamDeleteRequest()}
     *   <li>{@link TeamDeleteRequest#setFile_uri(String)}
     *   <li>{@link TeamDeleteRequest#setTeam_id(int)}
     *   <li>{@link TeamDeleteRequest#toString()}
     *   <li>{@link TeamDeleteRequest#getFile_uri()}
     *   <li>{@link TeamDeleteRequest#getTeam_id()}
     * </ul>
     */
    @Test
    void testConstructor() {
        TeamDeleteRequest actualTeamDeleteRequest = new TeamDeleteRequest();
        actualTeamDeleteRequest.setFile_uri("File uri");
        actualTeamDeleteRequest.setTeam_id(1);
        String actualToStringResult = actualTeamDeleteRequest.toString();
        String actualFile_uri = actualTeamDeleteRequest.getFile_uri();
        assertEquals("File uri", actualFile_uri);
        assertEquals("TeamDeleteRequest(file_uri=File uri, team_id=1)", actualToStringResult);
        assertEquals(1, actualTeamDeleteRequest.getTeam_id());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamDeleteRequest#TeamDeleteRequest(String, int)}
     *   <li>{@link TeamDeleteRequest#setFile_uri(String)}
     *   <li>{@link TeamDeleteRequest#setTeam_id(int)}
     *   <li>{@link TeamDeleteRequest#toString()}
     *   <li>{@link TeamDeleteRequest#getFile_uri()}
     *   <li>{@link TeamDeleteRequest#getTeam_id()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        TeamDeleteRequest actualTeamDeleteRequest = new TeamDeleteRequest("File uri", 1);
        actualTeamDeleteRequest.setFile_uri("File uri");
        actualTeamDeleteRequest.setTeam_id(1);
        String actualToStringResult = actualTeamDeleteRequest.toString();
        String actualFile_uri = actualTeamDeleteRequest.getFile_uri();
        assertEquals("File uri", actualFile_uri);
        assertEquals("TeamDeleteRequest(file_uri=File uri, team_id=1)", actualToStringResult);
        assertEquals(1, actualTeamDeleteRequest.getTeam_id());
    }

    /**
     * Method under test: {@link TeamDeleteRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new TeamDeleteRequest("File uri", 1), null);
        assertNotEquals(new TeamDeleteRequest("File uri", 1), "Different type to TeamDeleteRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamDeleteRequest#equals(Object)}
     *   <li>{@link TeamDeleteRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        TeamDeleteRequest teamDeleteRequest = new TeamDeleteRequest("File uri", 1);
        assertEquals(teamDeleteRequest, teamDeleteRequest);
        int expectedHashCodeResult = teamDeleteRequest.hashCode();
        assertEquals(expectedHashCodeResult, teamDeleteRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamDeleteRequest#equals(Object)}
     *   <li>{@link TeamDeleteRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        TeamDeleteRequest teamDeleteRequest = new TeamDeleteRequest("File uri", 1);
        TeamDeleteRequest teamDeleteRequest2 = new TeamDeleteRequest("File uri", 1);

        assertEquals(teamDeleteRequest, teamDeleteRequest2);
        int expectedHashCodeResult = teamDeleteRequest.hashCode();
        assertEquals(expectedHashCodeResult, teamDeleteRequest2.hashCode());
    }

    /**
     * Method under test: {@link TeamDeleteRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        TeamDeleteRequest teamDeleteRequest = new TeamDeleteRequest(null, 1);
        assertNotEquals(teamDeleteRequest, new TeamDeleteRequest("File uri", 1));
    }

    /**
     * Method under test: {@link TeamDeleteRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        TeamDeleteRequest teamDeleteRequest = new TeamDeleteRequest("com.runapp.guildservice.dto.request.TeamDeleteRequest",
                1);
        assertNotEquals(teamDeleteRequest, new TeamDeleteRequest("File uri", 1));
    }

    /**
     * Method under test: {@link TeamDeleteRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        TeamDeleteRequest teamDeleteRequest = new TeamDeleteRequest("File uri", 2);
        assertNotEquals(teamDeleteRequest, new TeamDeleteRequest("File uri", 1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamDeleteRequest#equals(Object)}
     *   <li>{@link TeamDeleteRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals7() {
        TeamDeleteRequest teamDeleteRequest = new TeamDeleteRequest(null, 1);
        TeamDeleteRequest teamDeleteRequest2 = new TeamDeleteRequest(null, 1);

        assertEquals(teamDeleteRequest, teamDeleteRequest2);
        int expectedHashCodeResult = teamDeleteRequest.hashCode();
        assertEquals(expectedHashCodeResult, teamDeleteRequest2.hashCode());
    }
}
