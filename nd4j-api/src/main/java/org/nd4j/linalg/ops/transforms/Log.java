package org.nd4j.linalg.ops.transforms;

import org.nd4j.linalg.api.complex.IComplexNumber;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.ops.BaseElementWiseOp;
import org.nd4j.linalg.util.ComplexUtil;

/**
 * Log transform
 *
 * @author Adam Gibson
 */
public class Log extends BaseElementWiseOp {
    /**
     * The transformation for a given value (a scalar ndarray)
     *
     * @param value the value to applyTransformToOrigin (a scalar ndarray)
     * @param i     the index of the element being acted upon
     * @return the transformed value based on the input
     */
    @Override
    public Object apply(INDArray from,Object value, int i) {
        if(value instanceof IComplexNumber) {
            return ComplexUtil.abs((org.nd4j.linalg.api.complex.IComplexNumber) value);
        }
        double ret = Math.log( (double) value);
        if(Double.isNaN(ret) || Double.isInfinite(ret))
            return Nd4j.EPS_THRESHOLD;
        return ret;
    }
}
