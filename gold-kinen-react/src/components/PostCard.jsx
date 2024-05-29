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
    <motion.div className="p-6 mb-11 bg-white rounded-lg shadow-[rgba(13,_38,_76,_0.19)_0px_9px_20px]"
    initial={{ y: 10, opacity: 0 }}
    animate={{ y: 0, opacity: 1 }}
    transition={{ duration: 0.4, delay: index * 0.5 }}>
      <h3 className="text-xl font-bold mb-2">{post.title}</h3>
      <p className="text-gray-700">{post.body}</p>
      <p className="text-sm font-bold mt-2 bg-gradient-to-r from-purple-500 via-pink-500 to-yellow-500 w-20% text-transparent bg-clip-text">By: {user.name}</p>
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



