@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(i8*, ...)
declare void @exit(i32 noundef)
define i32 @main() {
  %a = alloca i32, align 4
  store i32 0 , i32* %a
  %b = alloca i32, align 4
  store i32 0 , i32* %b
  %c = alloca i32, align 4
  store i32 0 , i32* %c
  store i32 6 , i32* %a
  store i32 12 , i32* %b
  store i32 18 , i32* %c
  %1 = load i32, i32* %a
  %2 = icmp sle i32 1 , %1
  br i1 %2, label %L1 , label %L2
L1:
  %3 = load i32, i32* %a
  %4 = icmp sle i32 %3 , 5
  br i1 %4, label %L3 , label %L4
L2:
  br label %L4;
L4:
  %5 = load i32, i32* %a
  store i32 %5 , i32* %b
  %6 = icmp sgt i32 %5 , 10
  br i1 %6, label %L5 , label %L6
L3:
  br label %L5;
L6:
  %7 = load i32, i32* %b
  %8 = load i32, i32* %a
  %9 = icmp eq i32 %7 , %8
  br i1 %9, label %L7 , label %L8
L5:
  br label %L8;
L8:
  %10 = load i32, i32* %b
  store i32 %10 , i32* %a
  br label %L0
L7:
  br label %L0
L0:
  %11 = load i32, i32* %a
  %12 = load i32, i32* %b
  %13 = icmp eq i32 %11 , %12
  br i1 %13, label %L10 , label %L11
L11:
  %14 = load i32, i32* %b
  %15 = load i32, i32* %c
  %16 = icmp eq i32 %14 , %15
  br i1 %16, label %L12 , label %L13
L10:
  br label %L12;
L12:
  %17 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str, i64 0, i64 0), i32 1)
  br label %L9
L13:
  br label %L9
L9:
  %18 = load i32, i32* %a
  %19 = load i32, i32* %b
  %20 = icmp eq i32 %18 , %19
  br i1 %20, label %L15 , label %L16
L16:
  %21 = load i32, i32* %b
  %22 = load i32, i32* %c
  %23 = icmp eq i32 %21 , %22
  br i1 %23, label %L17 , label %L18
L15:
  br label %L17;
L18:
  %24 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str, i64 0, i64 0), i32 2)
  br label %L14
L17:
  br label %L14
L14:
  %25 = load i32, i32* %a
  %26 = load i32, i32* %b
  %27 = icmp eq i32 %25 , %26
  br i1 %27, label %L20 , label %L21
L21:
  %28 = load i32, i32* %b
  %29 = load i32, i32* %c
  %30 = icmp eq i32 %28 , %29
  br i1 %30, label %L22 , label %L23
L20:
  br label %L23;
L23:
  %31 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str, i64 0, i64 0), i32 3)
  br label %L19
L22:
  br label %L19
L19:
  %32 = load i32, i32* %a
  %33 = load i32, i32* %b
  %34 = icmp eq i32 %32 , %33
  br i1 %34, label %L25 , label %L26
L26:
  %35 = load i32, i32* %b
  %36 = load i32, i32* %c
  %37 = icmp eq i32 %35 , %36
  br i1 %37, label %L27 , label %L28
L25:
  br label %L28;
L27:
  %38 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str, i64 0, i64 0), i32 4)
  br label %L24
L28:
  br label %L24
L24:
  %39 = load i32, i32* %a
  %40 = load i32, i32* %b
  %41 = icmp eq i32 %39 , %40
  br i1 %41, label %L30 , label %L31
L30:
  %42 = load i32, i32* %b
  %43 = load i32, i32* %c
  %44 = icmp eq i32 %42 , %43
  br i1 %44, label %L32 , label %L33
L31:
  br label %L33;
L32:
  %45 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str, i64 0, i64 0), i32 5)
  br label %L29
L33:
  br label %L29
L29:
  %46 = load i32, i32* %a
  %47 = load i32, i32* %b
  %48 = icmp eq i32 %46 , %47
  br i1 %48, label %L35 , label %L36
L35:
  %49 = load i32, i32* %b
  %50 = load i32, i32* %c
  %51 = icmp eq i32 %49 , %50
  br i1 %51, label %L37 , label %L38
L36:
  br label %L38;
L38:
  %52 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str, i64 0, i64 0), i32 6)
  br label %L34
L37:
  br label %L34
L34:
  %53 = load i32, i32* %a
  %54 = load i32, i32* %b
  %55 = icmp eq i32 %53 , %54
  br i1 %55, label %L40 , label %L41
L40:
  %56 = load i32, i32* %b
  %57 = load i32, i32* %c
  %58 = icmp eq i32 %56 , %57
  br i1 %58, label %L42 , label %L43
L41:
  br label %L42;
L43:
  %59 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str, i64 0, i64 0), i32 7)
  br label %L39
L42:
  br label %L39
L39:
  %60 = load i32, i32* %a
  %61 = load i32, i32* %b
  %62 = icmp eq i32 %60 , %61
  br i1 %62, label %L45 , label %L46
L45:
  %63 = load i32, i32* %b
  %64 = load i32, i32* %c
  %65 = icmp eq i32 %63 , %64
  br i1 %65, label %L47 , label %L48
L46:
  br label %L47;
L47:
  %66 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str, i64 0, i64 0), i32 8)
  br label %L44
L48:
  br label %L44
L44:
  %67 = load i32, i32* %a
  %68 = load i32, i32* %b
  %69 = mul i32 %67 , %68
  %70 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str, i64 0, i64 0), i32 %69)
  ret i32 0
}
