package com.user.tracking;

import com.user.tracking.service.TrackingNumberGeneratorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class TrackingApplicationTests {

	@Mock
	private StringRedisTemplate redisTemplate;

	@Mock
	private ValueOperations<String, String> ops;

	@InjectMocks
	private TrackingNumberGeneratorService trackingNumberGeneratorService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		when(redisTemplate.opsForValue()).thenReturn(ops);
		when(ops.setIfAbsent(anyString(), anyString())).thenReturn(true);

	}

	@Test
	public void testTrackingNumberIsNotNull() {

		String trackingNumber = trackingNumberGeneratorService.generateTrackingNumber();
		assertNotNull(trackingNumber, "Tracking number should not be null");
	}

	@Test
	public void testGenerateTrackingNumber() {

		String trackingNumber = trackingNumberGeneratorService.generateTrackingNumber();
		assertTrue(trackingNumber.startsWith("TN"));
		verify(ops, atLeastOnce()).setIfAbsent(anyString(), anyString());
	}

	@Test
	public void testTrackingNumbersAreUnique() {
		String trackingNumber1 = trackingNumberGeneratorService.generateTrackingNumber();
		String trackingNumber2 = trackingNumberGeneratorService.generateTrackingNumber();
		// Assert that the tracking numbers are different
		assertNotEquals(trackingNumber1, trackingNumber2);


	}

}
