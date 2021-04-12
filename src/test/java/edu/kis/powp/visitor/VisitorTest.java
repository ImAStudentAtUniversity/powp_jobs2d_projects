package edu.kis.powp.visitor;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.command.visitor.CommandTypeCounterVisitor;

import java.sql.Driver;

import org.junit.Assert;
import org.junit.Test;

public class VisitorTest {

    @Test
    public void testEmpty() {
        CommandTypeCounterVisitor visitor = new CommandTypeCounterVisitor();
        Assert.assertEquals(visitor.getOperateToCounter(), 0);
        Assert.assertEquals(visitor.getSetPositionCounter(), 0);
    }

    @Test
    public void testSingleCommandType() {
        int counterActual = 10;
        CommandTypeCounterVisitor visitor = new CommandTypeCounterVisitor();

        for (int i = 0; i < counterActual; i++) {
            new OperateToCommand((int) (Math.random() * 10), (int) (Math.random() * 10)).accept(visitor);
        }

        Assert.assertEquals(visitor.getOperateToCounter(), counterActual);
        Assert.assertEquals(visitor.getSetPositionCounter(), 0);
    }

    @Test
    public void testManyCommandTypes() {
        int setPositionActual = 10;
        int operateToActual = 14;
        CommandTypeCounterVisitor visitor = new CommandTypeCounterVisitor();

        for (int i = 0; i < setPositionActual; i++) {
            new SetPositionCommand((int) (Math.random() * 10), (int) (Math.random() * 10)).accept(visitor);
        }

        for (int i = 0; i < operateToActual; i++) {
            new OperateToCommand((int) (Math.random() * 10), (int) (Math.random() * 10)).accept(visitor);
        }

        Assert.assertEquals(visitor.getOperateToCounter(), operateToActual);
        Assert.assertEquals(visitor.getSetPositionCounter(), setPositionActual);
    }
}
