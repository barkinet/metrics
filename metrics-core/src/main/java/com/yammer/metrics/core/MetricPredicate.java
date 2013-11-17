package com.yammer.metrics.core;

/**
 * A {@link MetricPredicate} is used to determine whether a metric should be included when sorting
 * and filtering metrics. This is especially useful for limited metric reporting.
 */
public interface MetricPredicate {
    /**
     * A predicate which matches all inputs.
     */
    MetricPredicate ALL = new InclusiveMetricPredicate();

    public final static class InclusiveMetricPredicate implements MetricPredicate {
        @Override
        public boolean matches(MetricName name, Metric metric) {
            return true;
        }

        @Override
        public boolean matches(MetricName name, Metric metric, String measurement) {
            return true;
        }
    }

    /**
     * Returns {@code true} if the metric matches the predicate.
     *
     * @param name   the name of the metric
     * @param metric the metric itself
     * @return {@code true} if the predicate applies, {@code false} otherwise
     */
    boolean matches(MetricName name, Metric metric);

    /**
     * Returns {@code true} if the metric measurement matches the predicate.
     *
     * @param name   the name of the metric
     * @param metric the metric itself
     * @param measurement the measurement of the metric
     * @return {@code true} if the predicate applies, {@code false} otherwise
     */
    boolean matches(MetricName name, Metric metric, String measurement);
}
