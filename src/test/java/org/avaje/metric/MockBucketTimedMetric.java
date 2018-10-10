package org.avaje.metric;

/**
 * Test Double
 */
public class MockBucketTimedMetric implements TimedMetric {

  private final String name;

  private int count;

  public MockBucketTimedMetric(String name) {
    this.name = name;
  }

  @Override
  public void operationEnd(int opCode, long startNanos) {
    long exeNanos = System.nanoTime() - startNanos;
    System.out.println("... " + name + " operationEnd exe:" + exeNanos + " opCode:" + opCode);
    count++;
    MetricManager.operationEnd(name, opCode, false);
  }

  @Override
  public void operationEnd(int opCode, long startNanos, boolean activeThreadContext) {
    long exeNanos = System.nanoTime() - startNanos;
    System.out.println("... " + name + " operationEnd withActiveThread exe:" + exeNanos + " opCode:" + opCode);
    count++;
    MetricManager.operationEnd(name, opCode, activeThreadContext);
  }

  public boolean isActiveThreadContext() {
    return true;
  }

  /**
   * Return the count for the metric.
   */
  public int testGetCount() {
    return count;
  }

  /**
   * Reset count back to 0.
   */
  public void testReset() {
    count = 0;
  }
}
