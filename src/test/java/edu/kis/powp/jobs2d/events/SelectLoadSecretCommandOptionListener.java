package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.features.CommandsFeature;
import edu.kis.powp.jobs2d.features.FeatureManager;

public class SelectLoadSecretCommandOptionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		List<DriverCommand> commands = new ArrayList<DriverCommand>();
		commands.add(new SetPositionCommand(-20, -50));
		commands.add(new OperateToCommand(-20, -50));
		commands.add(new SetPositionCommand(-20, -40));
		commands.add(new OperateToCommand(-20, 50));
		commands.add(new SetPositionCommand(0, -50));
		commands.add(new OperateToCommand(0, -50));
		commands.add(new SetPositionCommand(0, -40));
		commands.add(new OperateToCommand(0, 50));
		commands.add(new SetPositionCommand(70, -50));
		commands.add(new OperateToCommand(20, -50));
		commands.add(new OperateToCommand(20, 0));
		commands.add(new OperateToCommand(70, 0));
		commands.add(new OperateToCommand(70, 50));
		commands.add(new OperateToCommand(20, 50));

		CommandsFeature commandsFeature = FeatureManager.getFeature(CommandsFeature.class);
		DriverCommandManager manager = commandsFeature.getDriverCommandManager();
		manager.setCurrentCommand(commands, "TopSecretCommand");
	}
}