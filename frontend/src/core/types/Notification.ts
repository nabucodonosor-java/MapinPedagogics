import { User } from "./User"

export type NotificationResponse = {
    content: Notification[];
    last: boolean;
    totalElements: number;
    totalPages: number;
    size?: number;
    number: number;
    first: boolean;
    numberOfElements?: number;
    empty?: boolean;
}

export type Notification = {
    id: number;
    publicationDate: string;
    message: string;
    read: boolean;
    user: User[];
}