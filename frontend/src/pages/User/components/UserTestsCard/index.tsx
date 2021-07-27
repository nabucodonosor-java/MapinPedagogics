import { User } from 'core/types/User';
import { makePrivateRequest } from 'core/utils/request';
import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import './styles.scss';

type ParamsType = { 
    userId: string;
}

const UserTestsCard = () => {

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
            <h6>Últimos testes realizados</h6>
            <p>Prova de Sociologia</p>
            <p>Prova de Sociologia</p>
            <p>Prova de Sociologia</p>
        </div>
    );
}

export default UserTestsCard;