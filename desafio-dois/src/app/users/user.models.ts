

export interface User {
    id: number;
    email: string;
    first_name: string;
    last_name: string;
    avatar: string;
}

export interface ResponseUsers {
    page: number;
    per_page: number;
    total: number;
    total_pages: number;
    data: User[];
}

//Model for creating user
export interface RequestCreate {
    name: string;
    job: string;
}

export interface ResponseCreate {
    name: string;
    job: string;
    id: string;
    createdAt: Date;
}

//Model for getting User
export interface ResponseUser {
    data: User
} 

//Model for updating user
export interface RequestUpdate {
    name: string;
    job: string;
}

export interface ResponseUpdate {
    name: string;
    job: string;
    updatedAt: Date;
}