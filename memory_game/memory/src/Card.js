import { motion } from 'framer-motion';

const Card = ({value, suit, visible, onClick}) => {
    const card_link = visible ? require(`./Cards/${value}_${suit}.png`) : require("./Cards/reverse.png");

    return (
        <motion.div
            onClick={onClick}
            className="card"
            style={{ cursor: 'pointer', perspective: '1000px', width: '100px', height: '150px' }}
        >
            <motion.div
                initial={{ rotateY: 0 }}
                animate={{ rotateY: visible ? 0 : 180 }}
                transition={{ duration: 0.5 }}
                style={{ width: '100%', height: '100%', position: 'relative' }}
            >
                <img 
                    style={{ width: '100%', height: 'auto', position: 'absolute', backfaceVisibility: 'hidden'}} 
                    src={card_link} 
                    alt={card_link} 
                />
            </motion.div>
        </motion.div>
    )
}
export default Card;