solve(state){

    // Base Case
    if(...)
        return ...;

    // Already Solved
    if(dp[state] != -1)
        return dp[state];

    // Compute Answer
    int option1 = ...;
    int option2 = ...;

    // Store Answer
    dp[state] = Math.max(option1, option2);

    return dp[state];
}