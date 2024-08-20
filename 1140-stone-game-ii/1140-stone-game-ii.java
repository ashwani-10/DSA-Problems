class Solution {
     public int stoneGameII(int[] stoneValue) {
        Map<Triple, Pair> cache = new HashMap<>();
        return help(stoneValue, 0, 1, 0, cache).x;
    }

    private Pair help(int[] sv, int start, int maximumToPick, int turn, Map<Triple, Pair> cache) {
        if (start >= sv.length) {
            return new Pair(0, 0);
        }
        Triple triple = new Triple(start, maximumToPick, turn);
        if (cache.containsKey(triple)) {
            return cache.get(triple);
        }

        int x = 0;
        int y = 0;
        // picking a result that maximizes x - y if turn == 0 else y - x
        int diff = Integer.MIN_VALUE;
        int currentMax = maximumToPick;
        int accumulated = 0;
        int nextTurn = turn == 0 ? 1 : 0;
        for (int i = start; i <= Math.min(start + 2 * maximumToPick - 1, sv.length - 1); i++) {
            accumulated += sv[i];
            // update maximum for next round
            int picked = i - start + 1;
            currentMax = Math.max(currentMax, picked);
            Pair nextTurnResult = help(sv, i + 1, currentMax, nextTurn, cache);
            int currentX = turn == 0 ? accumulated + nextTurnResult.x : nextTurnResult.x;
            int currentY = turn == 0 ? nextTurnResult.y : accumulated + nextTurnResult.y;
            if (turn == 0 && currentX - currentY > diff) {
                x = currentX;
                y = currentY;
                diff = currentX - currentY;
            }
            if (turn == 1 && currentY - currentX > diff) {
                x = currentX;
                y = currentY;
                diff = currentY - currentX;
            }
        }
        cache.put(triple, new Pair(x, y));
        return new Pair(x, y);
    }

    class Pair {

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    class Triple {
        int start;
        int maximumToPick;
        int turn;

        public Triple(int start, int maximumToPick, int turn) {
            this.start = start;
            this.maximumToPick = maximumToPick;
            this.turn = turn;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Triple triple = (Triple) o;
            return start == triple.start &&
                    maximumToPick == triple.maximumToPick &&
                    turn == triple.turn;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, maximumToPick, turn);
        }
    }
}