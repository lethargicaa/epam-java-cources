package com.epam.university.java.core.task019;

public class RobotImpl implements Robot {

    private RobotPosition startPosition = new RobotPositionImpl(0, 0);
    private RobotPosition robotPosition = new RobotPositionImpl(0, 0);
    private RobotDirection robotDirection = RobotDirection.NORTH;

    public RobotDirection getRobotDirection() {
        return robotDirection;
    }

    public RobotPosition getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(RobotPosition startPosition) {
        this.startPosition = startPosition;
    }


    @Override
    public RobotPosition getPosition() {
        return robotPosition;
    }

    @Override
    public void setPosition(RobotPosition position) {
        this.robotPosition = position;
    }

    @Override
    public void invokeAction(RobotCommand command) {
        switch (command) {
            case TURN_LEFT:
                robotDirection = robotDirection.ordinal() > 0
                        ? RobotDirection.values()[(robotDirection.ordinal() - 1)]
                        : RobotDirection.WEST;
                break;
            case TURN_RIGHT:
                robotDirection = RobotDirection.values()[(robotDirection.ordinal() + 1) % 4];
                break;
            case MOVE_FORWARD:
                switch (robotDirection) {
                    case NORTH:
                        robotPosition.setY(robotPosition.getY() + 1);
                        break;
                    case EAST:
                        robotPosition.setX(robotPosition.getX() + 1);
                        break;
                    case SOUTH:
                        robotPosition.setY(robotPosition.getY() - 1);
                        break;
                    case WEST:
                        robotPosition.setX(robotPosition.getX() - 1);
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }
}
