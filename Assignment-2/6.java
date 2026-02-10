public class WrapperDemo {
    public static void main(String[] args) {
        int primitiveInt = 100;

        // i) Basic type to Object (Autoboxing)
        Integer objInt = primitiveInt; 
        // Or explicitly: Integer.valueOf(primitiveInt);
        System.out.println("Object from basic: " + objInt);

        // ii) Object to Basic type (Unboxing)
        int backToPrimitive = objInt; 
        // Or explicitly: objInt.intValue();
        System.out.println("Basic from object: " + backToPrimitive);

        // iii) Basic type to String
        String strFromBasic = Integer.toString(primitiveInt);
        // Or: String.valueOf(primitiveInt);
        System.out.println("String from basic: " + strFromBasic);

        // iv) String (numeric data) to Numeric Object
        String numericStr = "250";
        Integer objFromStr = Integer.valueOf(numericStr);
        // Note: Integer.parseInt(numericStr) returns a primitive int
        System.out.println("Object from String: " + objFromStr);

        // v) Object to String
        String strFromObj = objInt.toString();
        System.out.println("String from object: " + strFromObj);
    }
}