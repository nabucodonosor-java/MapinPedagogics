import ButtonIcon from 'core/components/ButtonIcon';
import { Link } from 'react-router-dom';
import AboutImg from 'core/assets/images/about-img.jpeg';
import './styles.scss';

const Home = () => (
    <div className="home-container">
        <section className="featured" style={{
            backgroundSize: 'cover',
            backgroundPosition: 'center',
            backgroundImage: `url(https://mapin-pedagogics.s3.sa-east-1.amazonaws.com/background-pedagogics.jpeg)`
        }}>
            <div className="featured--vertical">
                <div className="featured--horizontal">
                    <p className="home-container-title">Localizada na cidade de Araraquara o Posto de Molas <br />
                        Tropical traz para o mercado o que há de melhor <br /> para o seu caminhão e utilitário.
                        Fundada em 1998, <br />a empresa é destaque na cidade e conquista novos <br />
                        clientes a cada dia. </p>

                    <div className="home-user-register">
                        <Link to="/users/new" className="btn-search">
                            <ButtonIcon text="cadastre-se" />
                        </Link>
                    </div>
                </div>

            </div>

        </section>

        <div className="home-content">

            <div>
                <h2 className="home-content-title">Nossa Missão</h2>
                <p className="home-content-paraph">Gerar conhecimento, disseminar a
                    cultura de inovação e incentivar o
                    desenvolvimento desse ecossistema
                    faz parte do DNA de todos os
                    envolvidos na realização deste estudo.</p>
            </div>
            <img className="home-content-img" src={AboutImg} alt="logo" />

        </div>
    </div>
);

export default Home;