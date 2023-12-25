package com.runapp.guildservice.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserTeamResponse.class})
@ExtendWith(SpringExtension.class)
class UserTeamResponseDiffblueTest {
    @Autowired
    private UserTeamResponse userTeamResponse;

    /**
     * Method under test: {@link UserTeamResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(userTeamResponse.canEqual("Other"));
        assertTrue(userTeamResponse.canEqual(userTeamResponse));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserTeamResponse#UserTeamResponse()}
     *   <li>{@link UserTeamResponse#setId(int)}
     *   <li>{@link UserTeamResponse#setTeamId(int)}
     *   <li>{@link UserTeamResponse#setUserId(int)}
     *   <li>{@link UserTeamResponse#toString()}
     *   <li>{@link UserTeamResponse#getId()}
     *   <li>{@link UserTeamResponse#getTeamId()}
     *   <li>{@link UserTeamResponse#getUserId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        UserTeamResponse actualUserTeamResponse = new UserTeamResponse();
        actualUserTeamResponse.setId(1);
        actualUserTeamResponse.setTeamId(1);
        actualUserTeamResponse.setUserId(1);
        String actualToStringResult = actualUserTeamResponse.toString();
        int actualId = actualUserTeamResponse.getId();
        int actualTeamId = actualUserTeamResponse.getTeamId();
        assertEquals("UserTeamResponse(id=1, userId=1, teamId=1)", actualToStringResult);
        assertEquals(1, actualId);
        assertEquals(1, actualTeamId);
        assertEquals(1, actualUserTeamResponse.getUserId());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserTeamResponse#UserTeamResponse(int, int, int)}
     *   <li>{@link UserTeamResponse#setId(int)}
     *   <li>{@link UserTeamResponse#setTeamId(int)}
     *   <li>{@link UserTeamResponse#setUserId(int)}
     *   <li>{@link UserTeamResponse#toString()}
     *   <li>{@link UserTeamResponse#getId()}
     *   <li>{@link UserTeamResponse#getTeamId()}
     *   <li>{@link UserTeamResponse#getUserId()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        UserTeamResponse actualUserTeamResponse = new UserTeamResponse(1, 1, 1);
        actualUserTeamResponse.setId(1);
        actualUserTeamResponse.setTeamId(1);
        actualUserTeamResponse.setUserId(1);
        String actualToStringResult = actualUserTeamResponse.toString();
        int actualId = actualUserTeamResponse.getId();
        int actualTeamId = actualUserTeamResponse.getTeamId();
        assertEquals("UserTeamResponse(id=1, userId=1, teamId=1)", actualToStringResult);
        assertEquals(1, actualId);
        assertEquals(1, actualTeamId);
        assertEquals(1, actualUserTeamResponse.getUserId());
    }

    /**
     * Method under test: {@link UserTeamResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new UserTeamResponse(1, 1, 1), null);
        assertNotEquals(new UserTeamResponse(1, 1, 1), "Different type to UserTeamResponse");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserTeamResponse#equals(Object)}
     *   <li>{@link UserTeamResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        UserTeamResponse userTeamResponse = new UserTeamResponse(1, 1, 1);
        assertEquals(userTeamResponse, userTeamResponse);
        int expectedHashCodeResult = userTeamResponse.hashCode();
        assertEquals(expectedHashCodeResult, userTeamResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserTeamResponse#equals(Object)}
     *   <li>{@link UserTeamResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        UserTeamResponse userTeamResponse = new UserTeamResponse(1, 1, 1);
        UserTeamResponse userTeamResponse2 = new UserTeamResponse(1, 1, 1);

        assertEquals(userTeamResponse, userTeamResponse2);
        int expectedHashCodeResult = userTeamResponse.hashCode();
        assertEquals(expectedHashCodeResult, userTeamResponse2.hashCode());
    }

    /**
     * Method under test: {@link UserTeamResponse#equals(Object)}
     */
    @Test
    void testEquals4() {
        UserTeamResponse userTeamResponse = new UserTeamResponse(2, 1, 1);
        assertNotEquals(userTeamResponse, new UserTeamResponse(1, 1, 1));
    }

    /**
     * Method under test: {@link UserTeamResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        UserTeamResponse userTeamResponse = new UserTeamResponse(1, 2, 1);
        assertNotEquals(userTeamResponse, new UserTeamResponse(1, 1, 1));
    }

    /**
     * Method under test: {@link UserTeamResponse#equals(Object)}
     */
    @Test
    void testEquals6() {
        UserTeamResponse userTeamResponse = new UserTeamResponse(1, 1, 2);
        assertNotEquals(userTeamResponse, new UserTeamResponse(1, 1, 1));
    }
}
