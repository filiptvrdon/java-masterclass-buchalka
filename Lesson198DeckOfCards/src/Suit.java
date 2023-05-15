public enum Suit {
    CLUB, DIAMOND, HEART, SPADE;

    public char getImage(){
        return switch (this) {
            case CLUB -> 9827;
            case DIAMOND -> 9830;
            case HEART -> 9829;
            case SPADE -> 9824;
            default -> 0;
        };
    }
}
