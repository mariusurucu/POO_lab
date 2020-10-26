
package test;


import java.io.IOException;
import java.lang.management.ManagementFactory;
import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;

import seriaf.poo.server.exceptions.InvalidFormatException;
import seriaf.poo.server.exceptions.MissingKeyException;
import seriaf.poo.server.exceptions.UnknownKeyException;

/**
 *
 * @author student
 */
public class Main {

    public static double main(String[] args) throws IOException, InvalidFormatException, UnknownKeyException, MissingKeyException, MalformedObjectNameException, InstanceNotFoundException, ReflectionException {
         MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            ObjectName name = ObjectName.getInstance("java.lang:type=OperatingSystem");
            AttributeList list = mbs.getAttributes(name, new String[]{"ProcessCpuLoad"});

            if (list.isEmpty()) {
                return Double.NaN;
            }

            Attribute att = (Attribute) list.get(0);
            Double value = (Double) att.getValue();

            // usually takes a couple of seconds before we get real values
            if (value == -1.0) {
                return Double.NaN;
            }
            // returns a percentage value with 1 decimal point precision
            return ((int) (value * 1000) / 10.0);

    }
}
