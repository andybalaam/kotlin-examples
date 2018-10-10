class Retry {
    static final long NEVER = -1L;
    static final long ONE_MINUTE = 1000L * 60L;
    static final long ONE_HOUR = ONE_MINUTE * 60L;

    static long whenToRetry(
        long now, int code, int tries
    ) {
        long reattemptTs = NEVER;

        switch (code) {
            case 451:
            case 381:
            case 2020:
                reattemptTs = now + (ONE_HOUR * tries);
                break;
            case 711:
            case 3010:
            case 1522:
                reattemptTs = now + ONE_MINUTE;
                break;
            case 2:
            case 815:
            default:
                reattemptTs = NEVER;
                break;
        }

        return reattemptTs;
    }
}
