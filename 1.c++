#define SIZE 10
#include <iostream>
int bfs(int input_size, int &path_length,int path[] ,bool adj_mat[][SIZE]){
    int parent_idx = input_size-1;
    int flag_Sweep = 0;
    int flag_found = 0;
    path_length = 0;
    int level1_neighbors[SIZE] = {0};
    int level2_neighbors[SIZE] = {0};
    int parent[SIZE] = {0};
    int seen[SIZE] = {0};
    bool root_flag = 1;
    for(int counter0 = 0; counter0 < input_size; counter0+=1){
        if(!flag_found){
            
            if(root_flag){
            
                root_flag = 0;
                seen[0] = 1;
            if(input_size == 1){
                path[0] = 0;
                break;
            }
            for(int counter1 = 0; counter1 < input_size; counter1+=1){
                if(adj_mat[0][counter1] == 1){
                    level1_neighbors[counter1] = 1;
                    parent[counter1] = 0;
                }
            }
        }
            else{
                flag_Sweep = 0;
                for(int counter1 = 0; counter1 < input_size; counter1+=1){
                    if(level1_neighbors[counter1] == 1 && seen[counter1] == 0){
                        flag_Sweep = 1;
                        seen[counter1] = 1;
                        if(counter1 == input_size-1){
                            parent_idx = counter1;
                            for(int counter2 = path_length+1; counter2 >0; counter2-=1){
                                path[parent_idx] = counter2;
                                parent_idx = parent[parent_idx];
                            }
                            flag_found = 1;
                            break;
                        }
                        else{
                            for(int counter2 = 0; counter2 < input_size; counter2+=1){
                                if(adj_mat[counter1][counter2] == 1 && seen[counter2]==0){
                                    level2_neighbors[counter2] = 1;
                                    parent[counter2] = counter1;
                                }
                            }
                        }
                    }
                }
                if(flag_Sweep)
                    path_length += 1;
                for(int counter2 = 0; counter2 < input_size; counter2+=1){
                    level1_neighbors[counter2] = level2_neighbors[counter2];
                }
            }
        }
    }
    return flag_found;
}
void delete_path(int input_size, int path_length,int path[] ,bool adj_mat[][SIZE]){
    int previous_index = 0;
    if(path_length == 1)
       adj_mat[0][input_size-1] = 0;
       adj_mat[input_size-1][0] = 0 ;
    for(int counter0 = 0; counter0 < path_length; counter0 = counter0 + 1){
        for(int counter1 = 0; counter1 < input_size; counter1 = counter1 + 1){
            if(path[counter1] == counter0){
                 adj_mat[previous_index][counter1] = 0;
                 adj_mat[counter1][previous_index] = 0;
                 previous_index = counter1;
                 break;
            }
        }
    }
}
int main(){
    bool adjacency_matrix[SIZE][SIZE]= {0};
    int path[SIZE]= {0};
    int path_length = 0;
    for(int counter1 = 1; counter1 < SIZE; counter1 = counter1 + 1){
       path[counter1] = -1;
    }
    path[0] = 0;
    int path_counter = 0;
    adjacency_matrix[0][9] = 1;
    adjacency_matrix[9][0] = 1;
    adjacency_matrix[0][1] = 1;
    adjacency_matrix[1][0] = 1;
    adjacency_matrix[1][9] = 1;
    adjacency_matrix[9][1] = 1;
    adjacency_matrix[0][2] = 1;
    adjacency_matrix[2][0] = 1;
    adjacency_matrix[0][3] = 1;
    adjacency_matrix[3][0] = 1;
    adjacency_matrix[0][4] = 1;
    adjacency_matrix[4][0] = 1;
    adjacency_matrix[2][5] = 1;
    adjacency_matrix[5][2] = 1;
    adjacency_matrix[3][6] = 1;
    adjacency_matrix[6][3] = 1;
    adjacency_matrix[4][6] = 1;
    adjacency_matrix[6][4] = 1;
    adjacency_matrix[4][7] = 1;
    adjacency_matrix[7][4] = 1;
    adjacency_matrix[7][8] = 1;
    adjacency_matrix[8][7] = 1;
    adjacency_matrix[8][9] = 1;
    adjacency_matrix[9][8] = 1;
    adjacency_matrix[5][8] = 1;
    adjacency_matrix[8][5] = 1;
    while( bfs(SIZE, path_length, path, adjacency_matrix)){
        path_counter += 1;
        std::cout<<"Path #"<< path_counter<<" : ";
        for(int counter1 = 0; counter1 < SIZE; counter1 = counter1 + 1){
            if(path[counter1] != -1){
                std::cout<<counter1+1<<"    ";
            }
        }
        std::cout<<std::endl;
        delete_path(SIZE, path_length, path, adjacency_matrix);
        for(int counter1 = 1; counter1 < SIZE; counter1 = counter1 + 1){
            path[counter1]=-1;
        }
    }
}

