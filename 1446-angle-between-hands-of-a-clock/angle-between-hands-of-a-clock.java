class Solution {
    public double angleClock(int hour, int minutes) {
        //calculate minutes hand
        double minutesAngle=minutes*6;
        //calculate hour hand abgle
        double hourAngle=(hour%12)*30+minutes*0.5;
        // Find the difference between angles
        double angle=Math.abs(hourAngle-minutesAngle);
        //return The Smaller Angle.......
        return Math.min(angle,360-angle);
    }
}