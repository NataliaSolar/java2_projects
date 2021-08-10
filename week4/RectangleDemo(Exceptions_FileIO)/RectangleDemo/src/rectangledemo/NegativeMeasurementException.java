/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangledemo;

/**
 *
 * @author alexandra.vaschillo
 */
public class NegativeMeasurementException extends Exception{
  
    
    public NegativeMeasurementException()
    {
        super("Negative Measurement");
    }
    public NegativeMeasurementException(double a)
    {
        super("Negative Measurement "+ a);
    }
}
    

