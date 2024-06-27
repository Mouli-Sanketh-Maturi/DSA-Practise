class Logger {

    Map<String, Integer> timeRecord;

    public Logger() {
        timeRecord = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(timeRecord.containsKey(message)) {
            if(timeRecord.get(message) + 10 > timestamp) {
                return false;
            }
        }
        timeRecord.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */