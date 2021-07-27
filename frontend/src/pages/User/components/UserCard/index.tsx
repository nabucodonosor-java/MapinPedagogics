import { User } from 'core/types/User';
import { makePrivateRequest } from 'core/utils/request';
import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import './styles.scss';

type ParamsType = { 
    userId: string;
}

const UserCard = () => {

    const { userId } = useParams<ParamsType>();
    const [user, setUser] = useState<User>();
    const [isLoading, setIsLoading] = useState(false);

    useEffect(() => {
        setIsLoading(true);
        makePrivateRequest({ url: `/users/${userId}`})
        .then(response => setUser(response.data))
        .finally(() => setIsLoading(false));
    }, [userId]);

    return (
        <div className="card-base border-radius-20 card-user">
            <img src={user?.imgUrl} alt={user?.name} />
            <h6>{user?.name}</h6>
        </div>
    );
}

export default UserCard;