let rec digMult n = if n < 10 then n else n % 10 * digMult(n / 10)
printf "%d \n" (digMult 12345)

