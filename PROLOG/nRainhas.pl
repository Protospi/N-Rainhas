% Declara procedimento verifique 
verifique(Linhas, Colunas) :-
  
  % Mapeia função plus para somar Linhas e Colunas  
  maplist(plus, Linhas, Colunas, Somas),
    
  % Mapeia a função plus para somar Linhas e Termos
  maplist(plus, Linhas, Termos, Colunas),
    
  % Verifica se conjuto Soma não possui elementos duplicados  
  is_set(Somas),
    
  % Verifica se conjuto Termo não possui elementos duplicados  
  is_set(Termos).

% Declara procedimento inteiro para lidar com excessão de tipo.
inteiro(N) :-
    (integer(N)
    -> integer(N)
    ; print("ERRO: O parâmetro fornecido não é um inteiro!")
    ).

% Declara procedimento positivo para lidar com excessão de domínio da veriável.
positivo(N) :-
    ( N > 0
    -> N > 0 
    ; print("ERRO: O parâmetro fornecido não é um inteiro positivo!")
    ).

% Declara procedimento posicione
posicioneImprima(Sol) :-
  
  % Mensagem para o usuário  
  write('Por favor insira a quantidade de rainhas: '),
    
  % Leitura
  read(Rainhas),  
    
  % Verifica se a entrada é um número inteiro e positivo  
  inteiro(Rainhas),
  positivo(Rainhas),
    
  % Gera lista de posições 1, ..., Rainhas  
  numlist(1, Rainhas, Colunas),

  % Procura todas as permutações de Colunas onde as condições de segurança são satisfeitas e coloca em Lista 
  findall(Posicao, (permutation(Colunas, Posicao), verifique(Posicao, Colunas)), Sol).
