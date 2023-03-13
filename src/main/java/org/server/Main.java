package org.server;

import org.idl.tasks.*;
import org.omg.CORBA.IntHolder;
import org.omg.CORBA.ORB;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        String str = "IOR:000000000000001a49444c3a7461736b732f496e697469616c5461736b3a312e3000000000000001000000000000008a000102000000000f3134372e3235312e35302e3234300000e2fe000000000031afabcb0000000020b6c969a200000001000000000000000100000008526f6f74504f410000000008000000010000000014000000000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002";

        try {
            ORB orb = ORB.init(args, null);

            InitialTask initialTask = InitialTaskHelper.narrow(orb.string_to_object(str));

            System.out.println("start task 1");
            SimpleTask simpleTask = SimpleTaskHelper.narrow(initialTask.init("485739@mail.muni.cz"));
            System.out.println(simpleTask.info());
            System.out.println("task end");

            System.out.println("start task 2");
            while (!simpleTask.isReady()) {
                System.out.println("waiting...");
                TimeUnit.SECONDS.sleep(10);
            }
            AdderTask adderTask = AdderTaskHelper.narrow(simpleTask.next());
            System.out.println(adderTask.info());
            System.out.println("task 2 end");

            System.out.println("start task 3");
            adderTask.result(adderTask.a() + adderTask.b());
            MatrixTask matrixTask = MatrixTaskHelper.narrow(adderTask.next());
            System.out.println(matrixTask.info());
            System.out.println("task 3 end");

            System.out.println("start task 4");
            long a = matrixTask.getMatrixItem(0, 0);
            long b = matrixTask.getMatrixItem(0, 1);
            long c = matrixTask.getMatrixItem(0, 2);
            long d = matrixTask.getMatrixItem(1, 0);
            long e = matrixTask.getMatrixItem(1, 1);
            long f = matrixTask.getMatrixItem(1, 2);
            long g = matrixTask.getMatrixItem(2, 0);
            long h = matrixTask.getMatrixItem(2, 1);
            long i = matrixTask.getMatrixItem(2, 2);
            matrixTask.sendResult((int) (a*e*i + b*f*g + c*d*h - c*e*g - b*d*i - a*f*h));
            PolygonTask polygonTask = PolygonTaskHelper.narrow(matrixTask.next());
            System.out.println(polygonTask.info());
            System.out.println("task 4 end");

            System.out.println("start task 5");
            Point[] polyLine = polygonTask.getPolyLine();
            float polyLineLength = 0;
            for (int j = 0; j < polyLine.length - 1; j++) {
                long x1 = polyLine[j].x;
                long y1 = polyLine[j].y;
                long x2 = polyLine[j + 1].x;
                long y2 = polyLine[j + 1].y;
                polyLineLength += Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            }
            polygonTask.sendResult(polyLineLength);
            FlipLineTask flipLineTask = FlipLineTaskHelper.narrow(polygonTask.next());
            System.out.println(flipLineTask.info());
            System.out.println("task 5 end");

            System.out.println("start task 6");
            Random random = new Random();
            int diff = 1;
            while (diff != 0) {
                double ratio = random.nextDouble();
                int n = (int) Math.ceil(polyLine.length * ratio);
                Point[] flippedPolyLine = new Point[n];
                for (int j = 0; j < n; j++) {
                    flippedPolyLine[j] = new Point();
                    flippedPolyLine[j].x = polyLine[j].y;
                    flippedPolyLine[j].y = polyLine[j].x;
                }
                IntHolder lengthDifference = new IntHolder();
                flipLineTask.update(flippedPolyLine, lengthDifference);
                diff = lengthDifference.value;
            }
            System.out.println(flipLineTask.next().info());
            System.out.println("task 6 end");

        } catch (TaskException e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}