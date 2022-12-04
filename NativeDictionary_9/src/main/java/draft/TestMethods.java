package draft;

public class TestMethods {
    public static NativeDictionary GenerateNative(int size)
    {
        NativeDictionary<String> testNativeDict = (NativeDictionary) new NativeDictionary<String>(size, String.class);
        for(int i=0; i<size; i++)
        {
            testNativeDict.put(String.valueOf(i) + "_key", String.valueOf(i) + "_value");
        }
        return testNativeDict;
    }

    public static void main(String[] args)
    {
        int a = 20;
        int b = 60;

        for(int i = 0; i < 60; i++)
            System.out.print(String.valueOf((int)(a + Math.random()*(b-a))) + "_key" + ", ");
    }
}
