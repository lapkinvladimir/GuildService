package com.runapp.guildservice.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ExceptionResponse.class})
@ExtendWith(SpringExtension.class)
class ExceptionResponseDiffblueTest {
    @Autowired
    private ExceptionResponse exceptionResponse;

    /**
     * Method under test: {@link ExceptionResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(exceptionResponse.canEqual("Other"));
        assertTrue(exceptionResponse.canEqual(exceptionResponse));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ExceptionResponse#ExceptionResponse()}
     *   <li>{@link ExceptionResponse#setResponse(String)}
     *   <li>{@link ExceptionResponse#setTimestamp(LocalDateTime)}
     *   <li>{@link ExceptionResponse#toString()}
     *   <li>{@link ExceptionResponse#getResponse()}
     *   <li>{@link ExceptionResponse#getTimestamp()}
     * </ul>
     */
    @Test
    void testConstructor() {
        ExceptionResponse actualExceptionResponse = new ExceptionResponse();
        actualExceptionResponse.setResponse("Response");
        LocalDateTime timestamp = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualExceptionResponse.setTimestamp(timestamp);
        String actualToStringResult = actualExceptionResponse.toString();
        String actualResponse = actualExceptionResponse.getResponse();
        assertEquals("ExceptionResponse(timestamp=1970-01-01T00:00, response=Response)", actualToStringResult);
        assertEquals("Response", actualResponse);
        assertSame(timestamp, actualExceptionResponse.getTimestamp());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ExceptionResponse#ExceptionResponse(LocalDateTime, String)}
     *   <li>{@link ExceptionResponse#setResponse(String)}
     *   <li>{@link ExceptionResponse#setTimestamp(LocalDateTime)}
     *   <li>{@link ExceptionResponse#toString()}
     *   <li>{@link ExceptionResponse#getResponse()}
     *   <li>{@link ExceptionResponse#getTimestamp()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        ExceptionResponse actualExceptionResponse = new ExceptionResponse(LocalDate.of(1970, 1, 1).atStartOfDay(),
                "Response");
        actualExceptionResponse.setResponse("Response");
        LocalDateTime timestamp = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualExceptionResponse.setTimestamp(timestamp);
        String actualToStringResult = actualExceptionResponse.toString();
        String actualResponse = actualExceptionResponse.getResponse();
        assertEquals("ExceptionResponse(timestamp=1970-01-01T00:00, response=Response)", actualToStringResult);
        assertEquals("Response", actualResponse);
        assertSame(timestamp, actualExceptionResponse.getTimestamp());
    }

    /**
     * Method under test: {@link ExceptionResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new ExceptionResponse(), null);
        assertNotEquals(new ExceptionResponse(), "Different type to ExceptionResponse");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ExceptionResponse#equals(Object)}
     *   <li>{@link ExceptionResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        assertEquals(exceptionResponse, exceptionResponse);
        int expectedHashCodeResult = exceptionResponse.hashCode();
        assertEquals(expectedHashCodeResult, exceptionResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ExceptionResponse#equals(Object)}
     *   <li>{@link ExceptionResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        ExceptionResponse exceptionResponse2 = new ExceptionResponse();
        assertEquals(exceptionResponse, exceptionResponse2);
        int expectedHashCodeResult = exceptionResponse.hashCode();
        assertEquals(expectedHashCodeResult, exceptionResponse2.hashCode());
    }

    /**
     * Method under test: {@link ExceptionResponse#equals(Object)}
     */
    @Test
    void testEquals4() {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDate.of(1970, 1, 1).atStartOfDay(), "Response");
        assertNotEquals(exceptionResponse, new ExceptionResponse());
    }

    /**
     * Method under test: {@link ExceptionResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        assertNotEquals(exceptionResponse, new ExceptionResponse(LocalDate.of(1970, 1, 1).atStartOfDay(), "Response"));
    }

    /**
     * Method under test: {@link ExceptionResponse#equals(Object)}
     */
    @Test
    void testEquals6() {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setResponse("Response");
        assertNotEquals(exceptionResponse, new ExceptionResponse());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ExceptionResponse#equals(Object)}
     *   <li>{@link ExceptionResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals7() {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDate.of(1970, 1, 1).atStartOfDay(), "Response");
        ExceptionResponse exceptionResponse2 = new ExceptionResponse(LocalDate.of(1970, 1, 1).atStartOfDay(), "Response");

        assertEquals(exceptionResponse, exceptionResponse2);
        int expectedHashCodeResult = exceptionResponse.hashCode();
        assertEquals(expectedHashCodeResult, exceptionResponse2.hashCode());
    }

    /**
     * Method under test: {@link ExceptionResponse#equals(Object)}
     */
    @Test
    void testEquals8() {
        ExceptionResponse exceptionResponse = new ExceptionResponse();

        ExceptionResponse exceptionResponse2 = new ExceptionResponse();
        exceptionResponse2.setResponse("Response");
        assertNotEquals(exceptionResponse, exceptionResponse2);
    }
}
