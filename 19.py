def f(x, h):
    if h == 3 and x >= 97:
        return 1
    if h == 3 and x < 97:
        return 0
    if h > 3 and x < 97:
        return 0
    if h % 2 == 0:
        return f(x + 1, h + 1) or f(x + 2, h + 1) or f(x * 2, h + 1)
    else:
        return f(x + 1, h + 1) or f(x + 2, h + 1) or f(x * 2, h + 1)

for s in range(1, 97):
    if f(s, 1) == 1:
        print(s)
        break