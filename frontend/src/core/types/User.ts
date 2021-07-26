export type UserResponse = {
    content: User[];
    last: boolean;
    totalElements: number;
    totalPages: number;
    size?: number;
    number: number;
    first: boolean;
    numberOfElements?: number;
    empty?: boolean;
}

export type User = {
    id: number;
    enrollmentDate: string;
    imgUrl: string;
    name: string;
    email: string;
    password: string;
    roles: Role[];
}

export type Role = {
    id: number;
    authority: string;
}
