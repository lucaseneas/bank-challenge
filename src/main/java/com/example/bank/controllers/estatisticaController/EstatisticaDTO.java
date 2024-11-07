package com.example.bank.controllers.estatisticaController;

import lombok.Getter;
import lombok.Setter;

import java.util.DoubleSummaryStatistics;

@Getter
@Setter
public class EstatisticaDTO {
    private long count;
    private Double sum;
    private Double min;
    private Double max;
    private Double avg;

    public EstatisticaDTO(DoubleSummaryStatistics doubleSummaryStatistics){
        this.count = doubleSummaryStatistics.getCount();
        this.sum = doubleSummaryStatistics.getSum();
        this.min = doubleSummaryStatistics.getMin() == Double.POSITIVE_INFINITY ? 0 : doubleSummaryStatistics.getMin();
        this.max = doubleSummaryStatistics.getMax() == Double.NEGATIVE_INFINITY ? 0 : doubleSummaryStatistics.getMax();
        this.avg = doubleSummaryStatistics.getAverage();
    }

}
