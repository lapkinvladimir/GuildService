package com.runapp.guildservice.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.runapp.guildservice.model.UserTeamModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TeamResponse.class})
@ExtendWith(SpringExtension.class)
class TeamResponseDiffblueTest {
    @Autowired
    private TeamResponse teamResponse;

    /**
     * Method under test: {@link TeamResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(teamResponse.canEqual("Other"));
        assertTrue(teamResponse.canEqual(teamResponse));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamResponse#TeamResponse()}
     *   <li>{@link TeamResponse#setAdminId(int)}
     *   <li>{@link TeamResponse#setCreateDate(LocalDateTime)}
     *   <li>{@link TeamResponse#setDescriptionTeam(String)}
     *   <li>{@link TeamResponse#setId(int)}
     *   <li>{@link TeamResponse#setMaximumPlayers(int)}
     *   <li>{@link TeamResponse#setRanking(Long)}
     *   <li>{@link TeamResponse#setStoryId(int)}
     *   <li>{@link TeamResponse#setTeamImageUrl(String)}
     *   <li>{@link TeamResponse#setTeamName(String)}
     *   <li>{@link TeamResponse#setUsers_in_team(List)}
     *   <li>{@link TeamResponse#toString()}
     *   <li>{@link TeamResponse#getAdminId()}
     *   <li>{@link TeamResponse#getCreateDate()}
     *   <li>{@link TeamResponse#getDescriptionTeam()}
     *   <li>{@link TeamResponse#getId()}
     *   <li>{@link TeamResponse#getMaximumPlayers()}
     *   <li>{@link TeamResponse#getRanking()}
     *   <li>{@link TeamResponse#getStoryId()}
     *   <li>{@link TeamResponse#getTeamImageUrl()}
     *   <li>{@link TeamResponse#getTeamName()}
     *   <li>{@link TeamResponse#getUsers_in_team()}
     * </ul>
     */
    @Test
    void testConstructor() {
        TeamResponse actualTeamResponse = new TeamResponse();
        actualTeamResponse.setAdminId(1);
        LocalDateTime createDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualTeamResponse.setCreateDate(createDate);
        actualTeamResponse.setDescriptionTeam("Description Team");
        actualTeamResponse.setId(1);
        actualTeamResponse.setMaximumPlayers(3);
        actualTeamResponse.setRanking(1L);
        actualTeamResponse.setStoryId(1);
        actualTeamResponse.setTeamImageUrl("https://example.org/example");
        actualTeamResponse.setTeamName("Team Name");
        ArrayList<UserTeamModel> users_in_team = new ArrayList<>();
        actualTeamResponse.setUsers_in_team(users_in_team);
        String actualToStringResult = actualTeamResponse.toString();
        int actualAdminId = actualTeamResponse.getAdminId();
        LocalDateTime actualCreateDate = actualTeamResponse.getCreateDate();
        String actualDescriptionTeam = actualTeamResponse.getDescriptionTeam();
        int actualId = actualTeamResponse.getId();
        int actualMaximumPlayers = actualTeamResponse.getMaximumPlayers();
        Long actualRanking = actualTeamResponse.getRanking();
        int actualStoryId = actualTeamResponse.getStoryId();
        String actualTeamImageUrl = actualTeamResponse.getTeamImageUrl();
        String actualTeamName = actualTeamResponse.getTeamName();
        List<UserTeamModel> actualUsers_in_team = actualTeamResponse.getUsers_in_team();
        assertEquals("Description Team", actualDescriptionTeam);
        assertEquals("Team Name", actualTeamName);
        assertEquals("TeamResponse(id=1, teamName=Team Name, descriptionTeam=Description Team, createDate=1970-01-01T00:00,"
                + " teamImageUrl=https://example.org/example, ranking=1, storyId=1, maximumPlayers=3, adminId=1,"
                + " users_in_team=[])", actualToStringResult);
        assertEquals("https://example.org/example", actualTeamImageUrl);
        assertEquals(1, actualAdminId);
        assertEquals(1, actualId);
        assertEquals(1, actualStoryId);
        assertEquals(1L, actualRanking.longValue());
        assertEquals(3, actualMaximumPlayers);
        assertSame(users_in_team, actualUsers_in_team);
        assertSame(createDate, actualCreateDate);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link TeamResponse#TeamResponse(int, String, String, LocalDateTime, String, Long, int, int, int, List)}
     *   <li>{@link TeamResponse#setAdminId(int)}
     *   <li>{@link TeamResponse#setCreateDate(LocalDateTime)}
     *   <li>{@link TeamResponse#setDescriptionTeam(String)}
     *   <li>{@link TeamResponse#setId(int)}
     *   <li>{@link TeamResponse#setMaximumPlayers(int)}
     *   <li>{@link TeamResponse#setRanking(Long)}
     *   <li>{@link TeamResponse#setStoryId(int)}
     *   <li>{@link TeamResponse#setTeamImageUrl(String)}
     *   <li>{@link TeamResponse#setTeamName(String)}
     *   <li>{@link TeamResponse#setUsers_in_team(List)}
     *   <li>{@link TeamResponse#toString()}
     *   <li>{@link TeamResponse#getAdminId()}
     *   <li>{@link TeamResponse#getCreateDate()}
     *   <li>{@link TeamResponse#getDescriptionTeam()}
     *   <li>{@link TeamResponse#getId()}
     *   <li>{@link TeamResponse#getMaximumPlayers()}
     *   <li>{@link TeamResponse#getRanking()}
     *   <li>{@link TeamResponse#getStoryId()}
     *   <li>{@link TeamResponse#getTeamImageUrl()}
     *   <li>{@link TeamResponse#getTeamName()}
     *   <li>{@link TeamResponse#getUsers_in_team()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        LocalDateTime createDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        ArrayList<UserTeamModel> users_in_team = new ArrayList<>();
        TeamResponse actualTeamResponse = new TeamResponse(1, "Team Name", "Description Team", createDate,
                "https://example.org/example", 1L, 1, 3, 1, users_in_team);
        actualTeamResponse.setAdminId(1);
        LocalDateTime createDate2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualTeamResponse.setCreateDate(createDate2);
        actualTeamResponse.setDescriptionTeam("Description Team");
        actualTeamResponse.setId(1);
        actualTeamResponse.setMaximumPlayers(3);
        actualTeamResponse.setRanking(1L);
        actualTeamResponse.setStoryId(1);
        actualTeamResponse.setTeamImageUrl("https://example.org/example");
        actualTeamResponse.setTeamName("Team Name");
        ArrayList<UserTeamModel> users_in_team2 = new ArrayList<>();
        actualTeamResponse.setUsers_in_team(users_in_team2);
        String actualToStringResult = actualTeamResponse.toString();
        int actualAdminId = actualTeamResponse.getAdminId();
        LocalDateTime actualCreateDate = actualTeamResponse.getCreateDate();
        String actualDescriptionTeam = actualTeamResponse.getDescriptionTeam();
        int actualId = actualTeamResponse.getId();
        int actualMaximumPlayers = actualTeamResponse.getMaximumPlayers();
        Long actualRanking = actualTeamResponse.getRanking();
        int actualStoryId = actualTeamResponse.getStoryId();
        String actualTeamImageUrl = actualTeamResponse.getTeamImageUrl();
        String actualTeamName = actualTeamResponse.getTeamName();
        List<UserTeamModel> actualUsers_in_team = actualTeamResponse.getUsers_in_team();
        assertEquals("Description Team", actualDescriptionTeam);
        assertEquals("Team Name", actualTeamName);
        assertEquals("TeamResponse(id=1, teamName=Team Name, descriptionTeam=Description Team, createDate=1970-01-01T00:00,"
                + " teamImageUrl=https://example.org/example, ranking=1, storyId=1, maximumPlayers=3, adminId=1,"
                + " users_in_team=[])", actualToStringResult);
        assertEquals("https://example.org/example", actualTeamImageUrl);
        assertEquals(1, actualAdminId);
        assertEquals(1, actualId);
        assertEquals(1, actualStoryId);
        assertEquals(1L, actualRanking.longValue());
        assertEquals(3, actualMaximumPlayers);
        assertEquals(users_in_team, actualUsers_in_team);
        assertSame(users_in_team2, actualUsers_in_team);
        assertSame(createDate2, actualCreateDate);
    }

    /**
     * Method under test: {@link TeamResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new TeamResponse(), null);
        assertNotEquals(new TeamResponse(), "Different type to TeamResponse");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamResponse#equals(Object)}
     *   <li>{@link TeamResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        TeamResponse teamResponse = new TeamResponse();
        assertEquals(teamResponse, teamResponse);
        int expectedHashCodeResult = teamResponse.hashCode();
        assertEquals(expectedHashCodeResult, teamResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamResponse#equals(Object)}
     *   <li>{@link TeamResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        TeamResponse teamResponse = new TeamResponse();
        TeamResponse teamResponse2 = new TeamResponse();
        assertEquals(teamResponse, teamResponse2);
        int expectedHashCodeResult = teamResponse.hashCode();
        assertEquals(expectedHashCodeResult, teamResponse2.hashCode());
    }

    /**
     * Method under test: {@link TeamResponse#equals(Object)}
     */
    @Test
    void testEquals4() {
        LocalDateTime createDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        TeamResponse teamResponse = new TeamResponse(1, "Team Name", "Description Team", createDate,
                "https://example.org/example", 1L, 1, 3, 1, new ArrayList<>());
        assertNotEquals(teamResponse, new TeamResponse());
    }

    /**
     * Method under test: {@link TeamResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        TeamResponse teamResponse = new TeamResponse();
        teamResponse.setTeamName("Team Name");
        assertNotEquals(teamResponse, new TeamResponse());
    }

    /**
     * Method under test: {@link TeamResponse#equals(Object)}
     */
    @Test
    void testEquals6() {
        TeamResponse teamResponse = new TeamResponse();
        teamResponse.setDescriptionTeam("Description Team");
        assertNotEquals(teamResponse, new TeamResponse());
    }

    /**
     * Method under test: {@link TeamResponse#equals(Object)}
     */
    @Test
    void testEquals7() {
        TeamResponse teamResponse = new TeamResponse();
        teamResponse.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertNotEquals(teamResponse, new TeamResponse());
    }

    /**
     * Method under test: {@link TeamResponse#equals(Object)}
     */
    @Test
    void testEquals8() {
        TeamResponse teamResponse = new TeamResponse();
        teamResponse.setTeamImageUrl("https://example.org/example");
        assertNotEquals(teamResponse, new TeamResponse());
    }

    /**
     * Method under test: {@link TeamResponse#equals(Object)}
     */
    @Test
    void testEquals9() {
        TeamResponse teamResponse = new TeamResponse();
        teamResponse.setRanking(1L);
        assertNotEquals(teamResponse, new TeamResponse());
    }

    /**
     * Method under test: {@link TeamResponse#equals(Object)}
     */
    @Test
    void testEquals10() {
        TeamResponse teamResponse = new TeamResponse();
        teamResponse.setStoryId(1);
        assertNotEquals(teamResponse, new TeamResponse());
    }

    /**
     * Method under test: {@link TeamResponse#equals(Object)}
     */
    @Test
    void testEquals11() {
        TeamResponse teamResponse = new TeamResponse();
        teamResponse.setMaximumPlayers(3);
        assertNotEquals(teamResponse, new TeamResponse());
    }

    /**
     * Method under test: {@link TeamResponse#equals(Object)}
     */
    @Test
    void testEquals12() {
        TeamResponse teamResponse = new TeamResponse();
        teamResponse.setAdminId(1);
        assertNotEquals(teamResponse, new TeamResponse());
    }

    /**
     * Method under test: {@link TeamResponse#equals(Object)}
     */
    @Test
    void testEquals13() {
        TeamResponse teamResponse = new TeamResponse();
        teamResponse.setUsers_in_team(new ArrayList<>());
        assertNotEquals(teamResponse, new TeamResponse());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamResponse#equals(Object)}
     *   <li>{@link TeamResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals14() {
        LocalDateTime createDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        TeamResponse teamResponse = new TeamResponse(1, "Team Name", "Description Team", createDate,
                "https://example.org/example", 1L, 1, 3, 1, new ArrayList<>());
        LocalDateTime createDate2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        TeamResponse teamResponse2 = new TeamResponse(1, "Team Name", "Description Team", createDate2,
                "https://example.org/example", 1L, 1, 3, 1, new ArrayList<>());

        assertEquals(teamResponse, teamResponse2);
        int expectedHashCodeResult = teamResponse.hashCode();
        assertEquals(expectedHashCodeResult, teamResponse2.hashCode());
    }

    /**
     * Method under test: {@link TeamResponse#equals(Object)}
     */
    @Test
    void testEquals15() {
        TeamResponse teamResponse = new TeamResponse();

        TeamResponse teamResponse2 = new TeamResponse();
        teamResponse2.setTeamName("Team Name");
        assertNotEquals(teamResponse, teamResponse2);
    }

    /**
     * Method under test: {@link TeamResponse#equals(Object)}
     */
    @Test
    void testEquals16() {
        TeamResponse teamResponse = new TeamResponse();

        TeamResponse teamResponse2 = new TeamResponse();
        teamResponse2.setDescriptionTeam("Description Team");
        assertNotEquals(teamResponse, teamResponse2);
    }

    /**
     * Method under test: {@link TeamResponse#equals(Object)}
     */
    @Test
    void testEquals17() {
        TeamResponse teamResponse = new TeamResponse();

        TeamResponse teamResponse2 = new TeamResponse();
        teamResponse2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        assertNotEquals(teamResponse, teamResponse2);
    }

    /**
     * Method under test: {@link TeamResponse#equals(Object)}
     */
    @Test
    void testEquals18() {
        TeamResponse teamResponse = new TeamResponse();

        TeamResponse teamResponse2 = new TeamResponse();
        teamResponse2.setTeamImageUrl("https://example.org/example");
        assertNotEquals(teamResponse, teamResponse2);
    }

    /**
     * Method under test: {@link TeamResponse#equals(Object)}
     */
    @Test
    void testEquals19() {
        TeamResponse teamResponse = new TeamResponse();

        TeamResponse teamResponse2 = new TeamResponse();
        teamResponse2.setRanking(1L);
        assertNotEquals(teamResponse, teamResponse2);
    }

    /**
     * Method under test: {@link TeamResponse#equals(Object)}
     */
    @Test
    void testEquals20() {
        TeamResponse teamResponse = new TeamResponse();

        TeamResponse teamResponse2 = new TeamResponse();
        teamResponse2.setUsers_in_team(new ArrayList<>());
        assertNotEquals(teamResponse, teamResponse2);
    }
}
