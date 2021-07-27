import AboutImg from 'core/assets/images/about-img.jpeg';
import './styles.scss';

const UserPublication = () => {

    return (


        <div className="card-base border-radius-20 user-publication">
            <div className="div-img-publication">
                <img src={AboutImg} alt="img" className="img-publication" />
            </div>
            <div className="div-comment">
                <img src="https://mapin-pedagogics.s3.sa-east-1.amazonaws.com/teacher_F.png" 
                alt="img" className="img-user-comment" />
                <p className="card-base border-radius-20 text-comment">Acabando os estudos. Bora pra prova!</p>
            </div>
        </div>
    );
}

export default UserPublication;