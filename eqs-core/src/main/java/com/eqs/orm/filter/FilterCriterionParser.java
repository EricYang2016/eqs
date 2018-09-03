/*
 * @date 2016年12月26日 17:04
 */
package com.eqs.orm.filter;

/**
 * @author june
 */
public interface FilterCriterionParser {

    Criterion createFilterCriterion(String property, DataType dataType,
                                    String expression);

}
