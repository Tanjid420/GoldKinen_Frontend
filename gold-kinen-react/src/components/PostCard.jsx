import  { useState } from 'react';
import { motion } from 'framer-motion';
import CommentList from './CommentList';
import PropTypes from 'prop-types';
import Button from './Button';

const PostCard = ({ post, user, comments,index }) => {
  const [isOpen, setIsOpen] = useState(false);
  const handleClick = ()=>{
    setIsOpen(!isOpen) 
  }

  return (
    <motion.div className="p-6 mb-16 bg-white rounded-lg shadow-[0px_4px_16px_rgba(17,17,26,0.1),_0px_8px_24px_rgba(17,17,26,0.1),_0px_16px_56px_rgba(17,17,26,0.1)]"
    initial={{ y: 10, opacity: 0 }}
    animate={{ y: 0, opacity: 1 }}
    transition={{ duration: 0.4, delay: index * 0.5 }}>
      <h3 className="text-xl font-bold mb-2">{post.title}</h3>
      <p className="text-gray-700">{post.body}</p>
      <div className='w-[250px]'>
      <p className="text-sm font-bold mt-2 text-transparent bg-clip-text bg-gradient-to-r from-pink-400 to-purple-700 ">By: {user.name}</p>
      </div>
      {/* <Button onClick={() => setIsOpen(!isOpen)}>
        {isOpen ? 'Hide Comments' : 'Show Comments'}
      </Button> */}
      <Button handleClick = {handleClick} isOpen={isOpen}/>
      {isOpen && (
        <motion.div initial={{ height: 0 }} animate={{ height: 'auto' }}>
          <CommentList comments={comments} />
        </motion.div>
      )}
    </motion.div>
  );
};

PostCard.propTypes = {
    post: PropTypes.shape({
      id: PropTypes.number.isRequired,
      title: PropTypes.string.isRequired,
      body: PropTypes.string.isRequired,
      userId: PropTypes.number.isRequired,
    }).isRequired,
    user: PropTypes.shape({
      id: PropTypes.number.isRequired,
      name: PropTypes.string.isRequired,
    }).isRequired,
    comments: PropTypes.arrayOf(
      PropTypes.shape({
        id: PropTypes.number.isRequired,
        body: PropTypes.string.isRequired,
        email: PropTypes.string.isRequired,
        postId: PropTypes.number.isRequired,
      })
    ).isRequired,
    index: PropTypes.number.isRequired,
  };

export default PostCard;



