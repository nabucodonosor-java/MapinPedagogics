import UserCard from "./components/UserCard";
import UserPublication from "./components/UserPublication";
import UserTestsCard from "./components/UserTestsCard";
import './styles.scss';

const User = () => {

    return (
        <div className="user-dashboard"> 
  
            <UserCard />
            <UserPublication />
            <UserTestsCard />
          
     
        </div>
    );
}

export default User;