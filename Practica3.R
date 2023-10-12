library(gtools)
n <- c("a1","a2","a3","a4")
D <- c(0,1)

#L = Longitud de las palabras codigo
compuesto <- function(n, d){
  L <- ceiling(log2(length(n))/log2(length(d)))
  tCodigos <- length(d)^L
  
  if(tCodigos >= length(n)){
    p <- permutations(n=length(d),L, d, repeats.allowed = TRUE)
    ind <- 1
    for(i in n){
      
      cat(paste( i, ": "))
      cat(paste(p[ind,]), "\n")
      ind <- ind + 1
    }
  }
  

}
compuesto(n,D)