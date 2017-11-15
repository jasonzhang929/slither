public class Testing {
    public static void main(String[] args) {
        gameframe testgame = new gameframe();
        assert (testgame.mysnake.head_x == 400.0);
        assert (testgame.mysnake.head_x == 240.0);
        testgame.mysnake.update(0.0, testgame.map, testgame.mouseloc);
        assert(testgame.mysnake.cord.get(0) == 0.0);
        assert(testgame.map.size_x == 3000.0);
        assert(testgame.map.size_y == testgame.map.size_x);
        testgame.mysnake.update(0.5, testgame.map, testgame.mouseloc);
        assert(testgame.mysnake.cord.get(0) == 0.29);
        testgame.mysnake.update(-0.5, testgame.map, testgame.mouseloc);
        assert(testgame.mysnake.cord.get(0) == -0.29);
        testgame.mysnake.set_boosting(true);
        testgame.mysnake.update(0.0, testgame.map, testgame.mouseloc);
        assert(testgame.mysnake.cord.get(0) == 0.0);
        testgame.mysnake.update(0.5, testgame.map, testgame.mouseloc);
        assert(testgame.mysnake.cord.get(0) == 0.19);
        testgame.mysnake.update(-0.6, testgame.map, testgame.mouseloc);
        assert(testgame.mysnake.cord.get(0) == -0.19);
        testgame.mysnake.update(0., testgame.map, testgame.mouseloc);
        assert(testgame.mysnake.cord.get(0) == 0.0);
        System.out.println("Passed");

    }


}
