class NeuralNetwork {

    public static float gradW1(float x1, float x2, float y, float w1, float w2) {

        float predictedY = w1 * x1 + w2 * x2;
        float error = predictedY - y;
        float gradientW1 = -2 * error * x1;
        return gradientW1;
    }

    public static float gradW2(float x1, float x2, float y, float w1, float w2) {
        float predictedY = w1 * x1 + w2 * x2;
        float error = predictedY - y;
        float gradientW2 = -2 * error * x2; 
        return gradientW2;
    }

    public static void main(String[] args) {
        float[][] data = {
            {1.0f, 0.0f, 1.0f},
            {2.0f, 1.0f, 9.0f},
            {0.0f, 1.0f, 1.0f},
            {-2.0f, 1.0f, 7.0f},
        };

        float w1 = 0.7f;
        float w2 = 0.5f;

        float lambda = 0.01f;

        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < data.length; i++) {
                float x1 = data[i][0];
                float x2 = data[i][1];
                float target = data[i][2];

                float gradW1 = gradW1(x1, x2, target, w1, w2);
                float gradW2 = gradW2(x1, x2, target, w1, w2);

                w1 = w1 - lambda * gradW1;
                w2 = w2 - lambda * gradW2;
            }

            System.out.println("Iteration " + (j + 1) + ": w1 = " + w1 + ", w2 = " + w2);
        }
    }
}
