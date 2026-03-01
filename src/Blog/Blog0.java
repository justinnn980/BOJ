static int N;
static int[] arr;
StringBuilder sb = new StringBuilder();
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    for (int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(br.readLine());
    }
    Solution(arr);
    System.out.println();
}

private static int Solution(int[] arr) {
    int result = 0;

    return result;
}