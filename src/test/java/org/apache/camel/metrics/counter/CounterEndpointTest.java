package org.apache.camel.metrics.counter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import org.apache.camel.Producer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.codahale.metrics.MetricRegistry;

@RunWith(MockitoJUnitRunner.class)
public class CounterEndpointTest {

    private static final String METRICS_NAME = "metrics.name";
    private static final Long VALUE = System.currentTimeMillis();

    @Mock
    private MetricRegistry registry;

    private CounterEndpoint endpoint;

    private InOrder inOrder;

    @Before
    public void setUp() throws Exception {
        endpoint = new CounterEndpoint(registry, METRICS_NAME);
        inOrder = Mockito.inOrder(registry);
    }

    @After
    public void tearDown() {
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void testCounterEndpoint() throws Exception {
        assertThat(endpoint.getRegistry(), is(registry));
        assertThat(endpoint.getMetricsName(), is(METRICS_NAME));
        assertThat(endpoint.getIncrement(), is(nullValue()));
        assertThat(endpoint.getDecrement(), is(nullValue()));
    }

    @Test
    public void testCreateProducer() throws Exception {
        Producer producer = endpoint.createProducer();
        assertThat(producer, is(notNullValue()));
        assertThat(producer, is(instanceOf(CounterProducer.class)));
    }

    @Test
    public void testGetIncrement() throws Exception {
        assertThat(endpoint.getIncrement(), is(nullValue()));
    }

    @Test
    public void testSetIncrement() throws Exception {
        assertThat(endpoint.getIncrement(), is(nullValue()));
        endpoint.setIncrement(VALUE);
        assertThat(endpoint.getIncrement(), is(VALUE));
    }

    @Test
    public void testGetDecrement() throws Exception {
        assertThat(endpoint.getDecrement(), is(nullValue()));
    }

    @Test
    public void testSetDecrement() throws Exception {
        assertThat(endpoint.getDecrement(), is(nullValue()));
        endpoint.setDecrement(VALUE);
        assertThat(endpoint.getDecrement(), is(VALUE));
    }

    @Test
    public void testCreateEndpointUri() throws Exception {
        assertThat(endpoint.createEndpointUri(), is(CounterEndpoint.ENDPOINT_URI));
    }
}
