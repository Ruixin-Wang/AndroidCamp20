int ViewCount(View root) {
    int viewCount = 0;
    if (!root) return 0;
    if (root instanceof ViewGroup) {
        viewCount++;
        for (int i = 0; i < root.getChildCount(); i++) {
            View view = root.getChildAt(i);
            if (view instanceof ViewGroup) viewCount += ViewCount(view);
            else viewCount++;
        }
    }
    return viewCount;
}