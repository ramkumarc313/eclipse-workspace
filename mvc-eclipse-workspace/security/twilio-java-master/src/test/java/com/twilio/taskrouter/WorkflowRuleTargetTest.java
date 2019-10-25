package com.twilio.taskrouter;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Test class for {@link WorkflowRuleTarget}
 */
public class WorkflowRuleTargetTest {

    @Test
    public void testToJson() throws IOException {
        WorkflowRuleTarget target = new WorkflowRuleTarget.Builder("QS123")
            .expression("1==1")
            .priority(5)
            .timeout(30)
            .build();

        Assert.assertEquals(
            "{\"queue\":\"QS123\",\"expression\":\"1==1\",\"priority\":5,\"timeout\":30}",
            target.toJson()
        );
    }

    @Test
    public void testFromJson() throws IOException {
        WorkflowRuleTarget target =
            WorkflowRuleTarget.fromJson("{\"queue\":\"QS123\",\"expression\":\"1==1\",\"priority\":5,\"timeout\":30}");

        Assert.assertEquals("QS123", target.getQueue());
        Assert.assertEquals("1==1", target.getExpression());
        Assert.assertEquals(5, (int)target.getPriority());
        Assert.assertEquals(30, (int)target.getTimeout());
    }
}
