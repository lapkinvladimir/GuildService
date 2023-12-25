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

@ContextConfiguration(classes = {UserTeamRequest.class})
@ExtendWith(SpringExtension.class)
class UserTeamRequestDiffblueTest {
    @Autowired
    private UserTeamRequest userTeamRequest;

    /**
     * Method under test: {@link UserTeamRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(userTeamRequest.canEqual("Other"));
        assertTrue(userTeamRequest.canEqual(userTeamRequest));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserTeamRequest#UserTeamRequest()}
     *   <li>{@link UserTeamRequest#setTeam_id(int)}
     *   <li>{@link UserTeamRequest#setUserId(int)}
     *   <li>{@link UserTeamRequest#toString()}
     *   <li>{@link UserTeamRequest#getTeam_id()}
     *   <li>{@link UserTeamRequest#getUserId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        UserTeamRequest actualUserTeamRequest = new UserTeamRequest();
        actualUserTeamRequest.setTeam_id(1);
        actualUserTeamRequest.setUserId(1);
        String actualToStringResult = actualUserTeamRequest.toString();
        int actualTeam_id = actualUserTeamRequest.getTeam_id();
        assertEquals("UserTeamRequest(userId=1, team_id=1)", actualToStringResult);
        assertEquals(1, actualTeam_id);
        assertEquals(1, actualUserTeamRequest.getUserId());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserTeamRequest#UserTeamRequest(int, int)}
     *   <li>{@link UserTeamRequest#setTeam_id(int)}
     *   <li>{@link UserTeamRequest#setUserId(int)}
     *   <li>{@link UserTeamRequest#toString()}
     *   <li>{@link UserTeamRequest#getTeam_id()}
     *   <li>{@link UserTeamRequest#getUserId()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        UserTeamRequest actualUserTeamRequest = new UserTeamRequest(1, 1);
        actualUserTeamRequest.setTeam_id(1);
        actualUserTeamRequest.setUserId(1);
        String actualToStringResult = actualUserTeamRequest.toString();
        int actualTeam_id = actualUserTeamRequest.getTeam_id();
        assertEquals("UserTeamRequest(userId=1, team_id=1)", actualToStringResult);
        assertEquals(1, actualTeam_id);
        assertEquals(1, actualUserTeamRequest.getUserId());
    }

    /**
     * Method under test: {@link UserTeamRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new UserTeamRequest(1, 1), null);
        assertNotEquals(new UserTeamRequest(1, 1), "Different type to UserTeamRequest");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserTeamRequest#equals(Object)}
     *   <li>{@link UserTeamRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        UserTeamRequest userTeamRequest = new UserTeamRequest(1, 1);
        assertEquals(userTeamRequest, userTeamRequest);
        int expectedHashCodeResult = userTeamRequest.hashCode();
        assertEquals(expectedHashCodeResult, userTeamRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserTeamRequest#equals(Object)}
     *   <li>{@link UserTeamRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        UserTeamRequest userTeamRequest = new UserTeamRequest(1, 1);
        UserTeamRequest userTeamRequest2 = new UserTeamRequest(1, 1);

        assertEquals(userTeamRequest, userTeamRequest2);
        int expectedHashCodeResult = userTeamRequest.hashCode();
        assertEquals(expectedHashCodeResult, userTeamRequest2.hashCode());
    }

    /**
     * Method under test: {@link UserTeamRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        UserTeamRequest userTeamRequest = new UserTeamRequest(2, 1);
        assertNotEquals(userTeamRequest, new UserTeamRequest(1, 1));
    }

    /**
     * Method under test: {@link UserTeamRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        UserTeamRequest userTeamRequest = new UserTeamRequest(1, 2);
        assertNotEquals(userTeamRequest, new UserTeamRequest(1, 1));
    }
}
