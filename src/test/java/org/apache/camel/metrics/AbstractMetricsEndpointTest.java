package org.apache.camel.metrics;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.RuntimeCamelException;
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
public class AbstractMetricsEndpointTest {

    private static final String METRICS_NAME = "metrics.name";

    @Mock
    private MetricRegistry registry;

    @Mock
    private Processor processor;

    private AbstractMetricsEndpoint endpoint;

    private InOrder inOrder;

    @Before
    public void setUp() throws Exception {
        endpoint = new AbstractMetricsEndpoint(registry, METRICS_NAME) {
            @Override
            public Producer createProducer() throws Exception {
                return null;
            }

            @Override
            protected String createEndpointUri() {
                return "not real endpoint";
            }
        };
        inOrder = Mockito.inOrder(registry, processor);
    }

    @After
    public void tearDown() throws Exception {
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void testAbstractMetricsEndpoint() throws Exception {
        assertThat(endpoint.getMetricsName(), is(METRICS_NAME));
        assertThat(endpoint.getRegistry(), is(registry));
    }

    @Test(expected = RuntimeCamelException.class)
    public void testCreateConsumer() throws Exception {
        endpoint.createConsumer(processor);
    }

    @Test
    public void testIsSingleton() throws Exception {
        assertThat(endpoint.isSingleton(), is(false));
    }

    @Test
    public void testGetRegistry() throws Exception {
        assertThat(endpoint.getRegistry(), is(registry));
    }

    @Test
    public void testGetMetricsName() throws Exception {
        assertThat(endpoint.getMetricsName(), is(METRICS_NAME));
    }
}
